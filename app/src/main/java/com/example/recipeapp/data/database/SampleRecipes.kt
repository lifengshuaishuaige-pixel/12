package com.example.recipeapp.data.database

import com.example.recipeapp.data.entity.*

/**
 * 内置示例食谱，首次安装时写入数据库
 */
object SampleRecipes {

    fun getSampleRecipes(): List<Recipe> = listOf(
        Recipe(
            title = "番茄炒蛋",
            description = "经典家常菜，酸甜可口，营养丰富。番茄富含维生素C和番茄红素，鸡蛋提供优质蛋白质，简单快手又美味。",
            imageUrl = null,
            category = "热菜",
            cuisine = "中餐",
            difficulty = Difficulty.EASY,
            prepTimeMinutes = 5,
            cookTimeMinutes = 10,
            servings = 2,
            caloriesPerServing = 180,
            ingredients = listOf(
                Ingredient("番茄", "2", "个", "中等大小，选熟透的"),
                Ingredient("鸡蛋", "3", "个", "常温鸡蛋更容易打散"),
                Ingredient("食用油", "2", "汤匙", null),
                Ingredient("盐", "1", "茶匙", null),
                Ingredient("糖", "1/2", "茶匙", "提鲜用，可选"),
                Ingredient("葱花", "适量", "", "装饰用")
            ),
            steps = listOf(
                CookingStep(1, "番茄洗净，顶部划十字，放入沸水中烫30秒，去皮切小块。鸡蛋打入碗中，加半茶匙盐打散备用。", null, 3, "番茄去皮口感更细腻，不喜欢去皮可省略"),
                CookingStep(2, "热锅凉油，倒入1汤匙食用油，油热后倒入蛋液，待底部凝固后用筷子快速划散，炒至八成熟盛出。", null, 2, "蛋液不要炒老，八成熟即可，后续还会回锅"),
                CookingStep(3, "锅中再加1汤匙油，放入番茄块，中火翻炒至出汁变软，可用锅铲压一压帮助出汁。", null, 3, "炒出番茄红油是关键"),
                CookingStep(4, "加入炒好的鸡蛋，翻炒均匀，加入剩余的盐和糖调味，炒至汤汁浓稠。", null, 2, "糖可以中和番茄的酸味"),
                CookingStep(5, "关火，撒上葱花，装盘即可。", null, null, "趁热食用风味最佳")
            ),
            tags = listOf("快手菜", "下饭", "素菜", "新手友好")
        ),
        Recipe(
            title = "宫保鸡丁",
            description = "川菜经典，鸡肉鲜嫩，花生酥脆，酸甜微辣，口感层次丰富。是一道色香味俱全的下饭神器。",
            imageUrl = null,
            category = "热菜",
            cuisine = "中餐",
            difficulty = Difficulty.MEDIUM,
            prepTimeMinutes = 20,
            cookTimeMinutes = 10,
            servings = 3,
            caloriesPerServing = 320,
            ingredients = listOf(
                Ingredient("鸡胸肉", "300", "克", "或鸡腿肉更嫩"),
                Ingredient("油炸花生米", "50", "克", null),
                Ingredient("干辣椒", "8", "个", "根据口味调整"),
                Ingredient("花椒", "1", "茶匙", null),
                Ingredient("大葱", "1", "根", "取葱白段"),
                Ingredient("姜", "3", "片", null),
                Ingredient("蒜", "3", "瓣", null),
                Ingredient("生抽", "2", "汤匙", null),
                Ingredient("老抽", "1/2", "汤匙", "上色用"),
                Ingredient("料酒", "1", "汤匙", null),
                Ingredient("醋", "2", "汤匙", "保宁醋最佳"),
                Ingredient("白糖", "2", "茶匙", null),
                Ingredient("淀粉", "2", "茶匙", null),
                Ingredient("盐", "1/2", "茶匙", null)
            ),
            steps = listOf(
                CookingStep(1, "鸡胸肉切成1.5厘米见方的丁，加入料酒、1茶匙淀粉和少许盐，抓匀腌制15分钟。", null, 15, "加淀粉腌制可以让鸡肉更嫩滑"),
                CookingStep(2, "调宫保汁：将生抽、老抽、醋、白糖、剩余的淀粉和2汤匙水混合，搅拌均匀备用。", null, 2, "提前调好汁，炒的时候不会手忙脚乱"),
                CookingStep(3, "干辣椒剪成段去籽，大葱切小段，姜蒜切片。", null, 3, "辣椒去籽可减少苦味"),
                CookingStep(4, "热锅倒油，油温五成热时下入鸡丁滑散，炒至变色后盛出备用。", null, 2, "滑炒时间不要太长，鸡肉变色即可"),
                CookingStep(5, "锅中留底油，放入花椒和干辣椒段，小火煸炒出香味，注意不要炒糊。", null, 1, "小火慢炒才能出香不糊"),
                CookingStep(6, "加入姜蒜片和葱段炒香，倒入鸡丁翻炒均匀。", null, 1, null),
                CookingStep(7, "倒入调好的宫保汁，大火快速翻炒收汁，最后加入花生米翻匀即可出锅。", null, 1, "花生米最后放才能保持酥脆")
            ),
            tags = listOf("川菜", "下饭菜", "经典菜", "聚餐")
        ),
        Recipe(
            title = "红烧肉",
            description = "肥而不腻、瘦而不柴，色泽红亮诱人。冰糖炒出的糖色让肉块裹上琥珀色的外衣，入口即化，回味无穷。",
            imageUrl = null,
            category = "热菜",
            cuisine = "中餐",
            difficulty = Difficulty.MEDIUM,
            prepTimeMinutes = 15,
            cookTimeMinutes = 60,
            servings = 4,
            caloriesPerServing = 480,
            ingredients = listOf(
                Ingredient("五花肉", "500", "克", "选三层五花，肥瘦相间"),
                Ingredient("冰糖", "30", "克", null),
                Ingredient("生抽", "2", "汤匙", null),
                Ingredient("老抽", "1", "汤匙", null),
                Ingredient("料酒", "2", "汤匙", null),
                Ingredient("八角", "2", "个", null),
                Ingredient("桂皮", "1", "小块", null),
                Ingredient("香叶", "2", "片", null),
                Ingredient("姜", "5", "片", null),
                Ingredient("大葱", "1", "根", null),
                Ingredient("盐", "适量", "", null)
            ),
            steps = listOf(
                CookingStep(1, "五花肉切成3厘米见方的块，冷水下锅，加入2片姜和1汤匙料酒，大火煮开后撇去浮沫，捞出用温水冲洗干净。", null, 5, "焯水要用冷水下锅，才能充分去除血沫"),
                CookingStep(2, "锅中放少许油，加入冰糖，小火慢慢炒至冰糖融化并变成琥珀色，注意不停搅拌防止炒糊。", null, 5, "炒糖色是红烧肉色泽红亮的关键，一定要小火"),
                CookingStep(3, "倒入焯好的肉块，快速翻炒使每块肉都裹上糖色。", null, 2, "动作要快，糖色容易糊"),
                CookingStep(4, "加入姜片、葱段、八角、桂皮、香叶炒香，再加入生抽、老抽和料酒翻炒均匀。", null, 2, null),
                CookingStep(5, "倒入没过肉块的热水，大火烧开后转小火，盖上锅盖慢炖45分钟。", null, 45, "一定要加热水，冷水会让肉变柴"),
                CookingStep(6, "打开锅盖，加适量盐调味，转大火收汁，期间不断翻动防止粘锅，直到汤汁浓稠包裹肉块。", null, 5, "收汁时要看着锅，汁浓即可关火"),
                CookingStep(7, "出锅装盘，撒少许葱花点缀。", null, null, "配米饭一绝")
            ),
            tags = listOf("硬菜", "宴客", "经典菜", "下饭")
        ),
        Recipe(
            title = "麻婆豆腐",
            description = "四川名菜，麻辣鲜香烫嫩酥，豆腐滑嫩入味，肉末酥香，红油透亮，是下米饭的绝佳搭配。",
            imageUrl = null,
            category = "热菜",
            cuisine = "中餐",
            difficulty = Difficulty.MEDIUM,
            prepTimeMinutes = 10,
            cookTimeMinutes = 15,
            servings = 3,
            caloriesPerServing = 220,
            ingredients = listOf(
                Ingredient("嫩豆腐", "400", "克", "南豆腐最佳"),
                Ingredient("牛肉末", "100", "克", "可用猪肉末代替"),
                Ingredient("郫县豆瓣酱", "2", "汤匙", null),
                Ingredient("花椒粉", "1", "茶匙", null),
                Ingredient("辣椒粉", "1", "茶匙", "根据口味调整"),
                Ingredient("蒜末", "1", "汤匙", null),
                Ingredient("姜末", "1", "茶匙", null),
                Ingredient("生抽", "1", "汤匙", null),
                Ingredient("淀粉", "2", "茶匙", "勾芡用"),
                Ingredient("青蒜苗", "2", "根", null),
                Ingredient("盐", "适量", "", null)
            ),
            steps = listOf(
                CookingStep(1, "豆腐切成2厘米见方的小块，放入加了少许盐的沸水中焯烫1分钟，捞出沥干水分。", null, 3, "焯水可以去豆腥味，让豆腐不易碎"),
                CookingStep(2, "热锅倒油，放入牛肉末，中火煸炒至肉末变色、水分收干，呈酥香状态。", null, 3, "肉末要炒酥才香"),
                CookingStep(3, "加入郫县豆瓣酱，小火炒出红油，再加入姜末、蒜末、辣椒粉炒香。", null, 2, "豆瓣酱要炒出红油才够味"),
                CookingStep(4, "倒入适量清水或高汤（约200毫升），加入生抽，烧开后轻轻放入豆腐块。", null, 2, "水不要太多，刚没过豆腐一半即可"),
                CookingStep(5, "中火煮5分钟，让豆腐充分吸收汤汁的味道，期间轻轻推动防止粘锅，不要大力翻炒。", null, 5, "用锅铲背轻推，避免豆腐碎掉"),
                CookingStep(6, "淀粉加2汤匙水调成水淀粉，分两次倒入锅中勾芡，轻轻推动使汤汁浓稠。", null, 2, "分两次勾芡更均匀"),
                CookingStep(7, "撒上花椒粉和切好的青蒜苗，出锅装盘。", null, null, "花椒粉最后放，麻味更突出")
            ),
            tags = listOf("川菜", "麻辣", "下饭", "素菜")
        ),
        Recipe(
            title = "紫菜蛋花汤",
            description = "清淡鲜美的快手汤品，5分钟即可上桌。紫菜富含碘和矿物质，蛋花嫩滑，汤鲜味美，适合搭配任何一餐。",
            imageUrl = null,
            category = "汤品",
            cuisine = "中餐",
            difficulty = Difficulty.EASY,
            prepTimeMinutes = 3,
            cookTimeMinutes = 5,
            servings = 2,
            caloriesPerServing = 80,
            ingredients = listOf(
                Ingredient("紫菜", "5", "克", null),
                Ingredient("鸡蛋", "2", "个", null),
                Ingredient("虾皮", "1", "茶匙", "提鲜用，可选"),
                Ingredient("香油", "1", "茶匙", null),
                Ingredient("盐", "适量", "", null),
                Ingredient("白胡椒粉", "少许", "", null),
                Ingredient("香菜或葱花", "适量", "", null)
            ),
            steps = listOf(
                CookingStep(1, "鸡蛋打散备用，紫菜用清水冲洗一下，撕成小块。", null, 2, "紫菜不要泡太久，冲洗即可"),
                CookingStep(2, "锅中加入500毫升清水，放入虾皮，大火烧开。", null, 2, "虾皮能显著提升汤的鲜味"),
                CookingStep(3, "水开后转小火，将蛋液画圈淋入锅中，待蛋花浮起后用筷子轻轻拨散。", null, 1, "淋蛋液时要小火，蛋花才嫩滑"),
                CookingStep(4, "加入紫菜，煮30秒，加盐和白胡椒粉调味。", null, 1, "紫菜煮太久会失去鲜味"),
                CookingStep(5, "关火，滴入香油，撒上香菜或葱花即可。", null, null, "香油最后加，香气更浓")
            ),
            tags = listOf("快手汤", "清淡", "素食", "早餐")
        ),
        Recipe(
            title = "香蕉松饼",
            description = "松软香甜的早餐松饼，利用熟透的香蕉天然甜味，无需烤箱，平底锅就能搞定，孩子超爱吃。",
            imageUrl = null,
            category = "甜点",
            cuisine = "西餐",
            difficulty = Difficulty.EASY,
            prepTimeMinutes = 10,
            cookTimeMinutes = 15,
            servings = 2,
            caloriesPerServing = 350,
            ingredients = listOf(
                Ingredient("熟透香蕉", "2", "根", "表皮有黑斑的最甜"),
                Ingredient("鸡蛋", "2", "个", null),
                Ingredient("低筋面粉", "120", "克", null),
                Ingredient("牛奶", "100", "毫升", null),
                Ingredient("细砂糖", "20", "克", "香蕉够甜可减量"),
                Ingredient("泡打粉", "3", "克", null),
                Ingredient("黄油", "20", "克", "融化备用"),
                Ingredient("蜂蜜", "适量", "", "淋面用")
            ),
            steps = listOf(
                CookingStep(1, "香蕉去皮放入碗中，用叉子压成细腻的泥状，保留少许颗粒口感更好。", null, 3, "香蕉越熟，松饼越香甜"),
                CookingStep(2, "加入鸡蛋、牛奶和融化的黄油，搅拌均匀。", null, 2, null),
                CookingStep(3, "筛入低筋面粉和泡打粉，加入细砂糖，用Z字形手法搅拌至无干粉即可，不要过度搅拌。", null, 3, "过度搅拌会让松饼发硬，有少许颗粒没关系"),
                CookingStep(4, "平底锅小火加热，无需放油，舀一勺面糊倒入锅中，自然摊成圆形。", null, null, "火一定要小，否则容易外糊内生"),
                CookingStep(5, "煎至表面出现密集小气泡、边缘微微凝固时（约2分钟），翻面再煎1分钟至金黄。", null, 3, "看到气泡再翻面是成功的关键"),
                CookingStep(6, "依次煎完所有面糊，叠放装盘，淋上蜂蜜，可加水果装饰。", null, 2, "可搭配蓝莓、草莓或酸奶")
            ),
            tags = listOf("早餐", "甜点", "儿童餐", "平底锅")
        ),
        Recipe(
            title = "蒜蓉西兰花",
            description = "翠绿爽口的健康素菜，蒜香浓郁，营养丰富。西兰花富含维生素C和膳食纤维，简单烹饪保留原汁原味。",
            imageUrl = null,
            category = "热菜",
            cuisine = "中餐",
            difficulty = Difficulty.EASY,
            prepTimeMinutes = 10,
            cookTimeMinutes = 5,
            servings = 2,
            caloriesPerServing = 90,
            ingredients = listOf(
                Ingredient("西兰花", "400", "克", "选花球紧实的"),
                Ingredient("大蒜", "6", "瓣", null),
                Ingredient("食用油", "2", "汤匙", null),
                Ingredient("盐", "1", "茶匙", null),
                Ingredient("蚝油", "1", "汤匙", null),
                Ingredient("淀粉", "1", "茶匙", "勾芡用")
            ),
            steps = listOf(
                CookingStep(1, "西兰花切成小朵，用淡盐水浸泡10分钟，再用流水冲洗干净，去除农药残留和小虫。", null, 10, "盐水浸泡能有效去除藏在花蕾里的小虫"),
                CookingStep(2, "大蒜剁成蒜末，淀粉加2汤匙水调成水淀粉备用。", null, 2, "蒜末不要太细，粗一点更香"),
                CookingStep(3, "烧一锅水，水开后加入少许盐和几滴油，放入西兰花焯水1分钟，捞出过凉水沥干。", null, 2, "加盐和油能保持西兰花翠绿，过凉水保持脆嫩"),
                CookingStep(4, "热锅倒油，油热后放入一半蒜末，小火炒至金黄出香味。", null, 1, "一半蒜末先炸香，一半后放保留蒜香"),
                CookingStep(5, "放入西兰花大火快炒30秒，加入蚝油、盐和剩下的蒜末翻炒均匀。", null, 1, null),
                CookingStep(6, "倒入水淀粉快速勾薄芡，翻炒均匀即可出锅。", null, 1, "薄芡让味道均匀裹在西兰花上")
            ),
            tags = listOf("素菜", "健康", "减脂", "快手菜")
        ),
        Recipe(
            title = "可乐鸡翅",
            description = "深受欢迎的家常菜，鸡翅鲜嫩入味，色泽红亮，带着可乐独特的焦糖香甜，做法简单零失败。",
            imageUrl = null,
            category = "热菜",
            cuisine = "中餐",
            difficulty = Difficulty.EASY,
            prepTimeMinutes = 10,
            cookTimeMinutes = 25,
            servings = 3,
            caloriesPerServing = 380,
            ingredients = listOf(
                Ingredient("鸡中翅", "500", "克", "约10-12个"),
                Ingredient("可乐", "330", "毫升", "一罐，不要用无糖可乐"),
                Ingredient("生抽", "2", "汤匙", null),
                Ingredient("老抽", "1/2", "汤匙", null),
                Ingredient("料酒", "1", "汤匙", null),
                Ingredient("姜", "4", "片", null),
                Ingredient("盐", "少许", "", null)
            ),
            steps = listOf(
                CookingStep(1, "鸡翅洗净，两面各划两刀方便入味。冷水下锅，加2片姜和料酒，煮开后撇去浮沫，捞出沥干。", null, 5, "焯水后可以用厨房纸吸干水分，煎的时候不易溅油"),
                CookingStep(2, "平底锅放少许油，将鸡翅皮朝下放入，中小火煎至两面金黄。", null, 6, "先煎皮朝下，可以逼出鸡皮里的油脂"),
                CookingStep(3, "加入姜片炒香，倒入生抽和老抽，翻炒使鸡翅上色均匀。", null, 1, null),
                CookingStep(4, "倒入可乐，量以刚好没过鸡翅为宜，大火烧开后转中小火，盖上锅盖焖煮15分钟。", null, 15, "可乐会越煮越甜，不要用无糖的"),
                CookingStep(5, "打开锅盖，大火收汁，期间不断翻动鸡翅，让汤汁均匀裹在鸡翅上，直到汤汁浓稠。", null, 3, "收汁时要不停翻动，可乐糖分高容易糊底"),
                CookingStep(6, "出锅装盘，将剩余的浓稠酱汁淋在鸡翅上。", null, null, "撒点白芝麻更香")
            ),
            tags = listOf("快手菜", "下饭", "儿童喜爱", "零失败")
        )
    )
}
