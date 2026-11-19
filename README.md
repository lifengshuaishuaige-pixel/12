# 美食食谱 - Android 食谱应用

一个基于 Jetpack Compose 的现代化 Android 食谱应用，支持食谱浏览、搜索、收藏、详细制作步骤查看等功能。

## 功能特性

- 🍳 **食谱浏览** - 卡片式展示食谱列表，包含图片、标题、烹饪时间、人份、难度等信息
- 🔍 **搜索功能** - 支持按标题、描述搜索食谱
- ❤️ **收藏功能** - 可收藏/取消收藏喜欢的食谱
- 📖 **详细制作步骤** - 每个食谱包含配料表和分步制作说明，支持步骤图片、耗时、小贴士
- 🏷️ **分类标签** - 支持菜系分类、难度标签
- 💾 **本地数据库** - 使用 Room 数据库持久化存储，首次启动自动导入 8 道经典示例食谱

## 技术栈

- **UI**: Jetpack Compose (Material 3)
- **架构**: MVVM + Repository + Hilt 依赖注入
- **数据库**: Room (SQLite)
- **图片加载**: Coil
- **导航**: Navigation Compose
- **异步**: Kotlin Coroutines + Flow
- **序列化**: kotlinx.serialization (用于复杂数据类型存储)

## 预置食谱 (8 道)

1. **番茄炒蛋** - 经典家常菜，简单快手 (简单)
2. **宫保鸡丁** - 川菜经典，酸甜微辣 (中等)
3. **红烧肉** - 色泽红亮，肥而不腻 (中等)
4. **麻婆豆腐** - 麻辣鲜香，下饭神器 (中等)
5. **紫菜蛋花汤** - 清淡鲜美，5分钟上桌 (简单)
6. **香蕉松饼** - 松软香甜，平底锅即做 (简单)
7. **蒜蓉西兰花** - 翠绿爽口，健康减脂 (简单)
8. **可乐鸡翅** - 焦糖香甜，儿童最爱 (简单)

## 运行要求

- Android Studio Koala (2024.1.1) 或更高版本
- JDK 17
- Android SDK API 34
- 最低支持 Android 7.0 (API 24)

## 构建与运行

### 方式一：使用 Android Studio (推荐)

1. 打开 Android Studio
2. 选择 `File` → `Open`，选择本项目根目录
3. 等待 Gradle 同步完成
4. 连接 Android 设备或启动模拟器
5. 点击 `Run` (▶️) 按钮运行应用

### 方式二：使用命令行

```bash
# 确保已配置 ANDROID_HOME 环境变量
export ANDROID_HOME=$HOME/Library/Android/sdk  # macOS
# 或
export ANDROID_HOME=$HOME/Android/Sdk  # Linux

# Windows PowerShell
$env:ANDROID_HOME = "C:\Users\<用户名>\AppData\Local\Android\Sdk"

# 构建 Debug APK
./gradlew assembleDebug

# 安装到已连接设备
./gradlew installDebug
```

## 项目结构

```
app/
├── src/main/
│   ├── java/com/example/recipeapp/
│   │   ├── data/
│   │   │   ├── converter/      # Room 类型转换器
│   │   │   ├── dao/            # 数据访问对象
│   │   │   ├── database/       # Room 数据库 + 示例数据
│   │   │   ├── entity/         # 数据实体
│   │   │   └── repository/     # 数据仓库
│   │   ├── di/                 # Hilt 依赖注入模块
│   │   ├── ui/
│   │   │   ├── components/     # 可复用 UI 组件
│   │   │   ├── navigation/     # 导航图
│   │   │   ├── screen/         # 页面 Composable
│   │   │   ├── theme/          # 主题、颜色、排版
│   │   │   └── viewmodel/      # ViewModel
│   │   ├── RecipeApplication.kt
│   │   └── MainActivity.kt
│   ├── res/
│   │   ├── values/             # 字符串、颜色、主题
│   │   ├── drawable/           # 图标、背景
│   │   ├── mipmap-*/           # 启动图标
│   │   └── xml/                # 备份规则
│   └── AndroidManifest.xml
└── build.gradle.kts
```

## 关键实现细节

### 数据模型
- `Recipe`: 食谱主实体，包含配料列表、步骤列表、标签等复杂字段
- `Ingredient`: 配料 (名称、用量、单位、备注)
- `CookingStep`: 制作步骤 (序号、说明、图片、耗时、小贴士)
- `Difficulty`: 难度枚举 (简单/中等/困难)

### 存储策略
复杂列表类型 (ingredients、steps、tags) 使用 `kotlinx.serialization` 序列化为 JSON 字符串存储在 SQLite 文本列中，通过 Room `TypeConverter` 自动转换。

### 示例数据初始化
通过 `RoomDatabase.Callback.onCreate()` 在数据库首次创建时异步插入 8 道预置食谱。

## 截图预览

应用包含两个主要页面：
1. **食谱列表页** - 顶部搜索栏 + 收藏入口，卡片式食谱列表
2. **食谱详情页** - 顶部图片/标题/元信息，配料卡片，制作步骤列表 (每步含编号、说明、耗时、小贴士)

## 许可证

MIT License - 仅供学习交流使用