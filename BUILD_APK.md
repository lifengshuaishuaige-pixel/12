# APK 构建指南

由于当前环境未安装 Android SDK，无法直接在本机构建 APK。请在已安装 **Android Studio** 的电脑上按以下步骤操作：

---

## 方式一：Android Studio 图形界面（推荐）

1. **打开项目**
   - 启动 Android Studio
   - `File` → `Open` → 选择 `C:\Users\v3163\Documents\deepseek-harness\default-workspace` 目录
   - 等待 Gradle 同步完成（右下角进度条消失）

2. **构建 Debug APK**
   - 菜单栏 `Build` → `Build Bundle(s) / APK(s)` → `Build APK(s)`
   - 等待构建完成，右下角弹窗点击 `locate` 可直接打开输出目录
   - **输出路径**：`app/build/outputs/apk/debug/app-debug.apk`

3. **构建 Release APK（可发布）**
   - `Build` → `Generate Signed Bundle / APK...`
   - 选择 `APK` → `Next`
   - 密钥库选择或创建（首次需 `Create new` 填写信息）
   - 勾选 `release`，勾选 `V1 (Jar Signature)` 和 `V2 (Full APK Signature)`
   - `Finish` 等待完成
   - **输出路径**：`app/build/outputs/apk/release/app-release.apk`

---

## 方式二：命令行（适合 CI/CD）

```bash
# 1. 确保环境变量（按实际路径修改）
export ANDROID_HOME=$HOME/Library/Android/sdk        # macOS
export ANDROID_HOME=$HOME/Android/Sdk                # Linux
# Windows PowerShell:
$env:ANDROID_HOME = "C:\Users\<用户名>\AppData\Local\Android\Sdk"

# 2. 进入项目根目录
cd C:\Users\v3163\Documents\deepseek-harness\default-workspace

# 3. 清理并构建 Debug APK
./gradlew clean assembleDebug

# 4. 构建 Release APK（需先配置签名，见下文）
./gradlew clean assembleRelease
```

**输出位置**：
- Debug：`app/build/outputs/apk/debug/app-debug.apk`
- Release：`app/build/outputs/apk/release/app-release.apk`

---

## 方式三：配置 Release 签名（在 `app/build.gradle.kts` 中）

在 `android { ... }` 内添加：

```kotlin
signingConfigs {
    create("release") {
        storeFile = file("keystore.jks")
        storePassword = "your_store_password"
        keyAlias = "your_key_alias"
        keyPassword = "your_key_password"
    }
}
buildTypes {
    release {
        isMinifyEnabled = true
        proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        signingConfig = signingConfigs.getByName("release")
    }
}
```

> ⚠️ 真实密钥请勿提交到版本控制，建议用 `local.properties` 或环境变量注入。

---

## 常见问题排查

| 问题 | 解决方法 |
|------|----------|
| `SDK location not found` | 检查 `local.properties` 中 `sdk.dir` 路径，或在 Android Studio `SDK Manager` 确认 SDK 已安装 |
| `CompileSdk version 34 not found` | 在 SDK Manager 安装 **Android 14 (API 34) SDK Platform** |
| `Kotlin version mismatch` | 确保 Android Studio 版本 ≥ Koala (2024.1.1)，或在 `gradle.properties` 调整 `kotlinVersion` |
| `OutOfMemoryError` | 在 `gradle.properties` 增加：`org.gradle.jvmargs=-Xmx4096m -Dfile.encoding=UTF-8` |
| Hilt 编译报错 | 确保 `kapt` 插件已应用，且 `buildFeatures { compose = true }` 已开启 |

---

## 验证 APK 安装

```bash
# 连接真机或启动模拟器（已授权 USB 调试）
adb install -r app/build/outputs/apk/debug/app-debug.apk

# 或直接拖拽 APK 到模拟器窗口安装
```

启动后应看到：
1. **食谱列表页** — 8 道预置菜（番茄炒蛋、宫保鸡丁、红烧肉…）
2. 点击任意卡片进入 **详情页** — 配料表 + 分步制作步骤（含耗时/小贴士/步骤图占位）
3. 顶部搜索栏可过滤、右上角爱心可收藏

---

## 快速体验（无需构建）

若仅想预览 UI，可在 Android Studio 中：
- 右键 `RecipeListScreen.kt` / `RecipeDetailScreen.kt` → `Preview` → 点击编辑器右侧 `Split` 查看 Compose 预览
- 或运行 `./gradlew :app:compileDebugKotlin` 仅做编译检查（不打包 APK）