# MyKotlins
    kotlin apps
# 01_birthday
    上手APK
# 02_dict
    熟悉if when
# 03_lemonade
    练手
# 04_class
    with:当您使用某个类的特定实例，并需要访问该实例的多个属性和函数时，您可以使用 with 语句表明 
    open:默认情况下，在 Kotlin 中，类是最终层级，无法被子类化。
        您只能从 abstract 类或标记有 open 关键字的类继承。
        因此，您需要使用 open 关键字标记子类，使其能够被继承。
    注意：定义抽象类时，您无需使用 open 关键字。
        例如，无需使用 open 关键字标记 基类。系统已假设您需要子类化抽象类，以实现抽象属性和函数。 
# 05_tiptime
    布局 UI   click
# 06_affirmations
    google实例
# 07_list
    google实例
# 08_fragment
    google实例，navigation的联系
# 09_unscramble
    google实例，viewBinding，LiveData
    android{
        ...
        buildFeatures { viewBinding = true  }
    }
# 10_unscramble_dataBinding
    google实例，dataBinding联系
    plugins {
        id 'kotlin-kapt'    //插件
    }
    android{
        ...
        buildFeatures { dataBinding = true  }
    }
    
    
