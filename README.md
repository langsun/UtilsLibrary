# UtilsLibrary
Android开发过程中常用的工具类

### How to use it?
Step 1. Add it in your root build.gradle at the end of repositories:

    allprojects {
    		repositories {
    			...
    			maven { url 'https://jitpack.io' }
    		}
     }
     
Step 2. Add the dependency 
   	 
   	  dependencies {
      	        implementation 'com.github.langsun:UtilsLibrary:v1.2'
      	}
#### SPUtil
    setString(Context context, String key, boolean value)          :String类型的写入
    getString(Context context, String key, boolean defaultValue)   :String类型的读取

    setBoolean(Context context, String key, boolean value)         :Boolean类型的写入
    getBoolean(Context context, String key, boolean defaultValue)  :Boolean类型的读取

    setInt(Context context, String key, boolean value)             :int类型的写入
    getInt(Context context, String key, boolean defaultValue)      :int类型的读取

    setLong(Context context, String key, boolean value)            :long类型的写入
    getLong(Context context, String key, boolean defaultValue)     :long类型的读取

    setFloat(Context context, String key, float value)            :float类型的写入
    getFloat(Context context, String key, float defaultValue)     :float类型的读取

    keyExist(Context context, String key)		                   :判断该key是否存在
    getSP(Context context)		                                   :获取当前的sp


#### ToastUtil

     showToast(Context context, String str)                      :String类型的提示文案
     showToast(Context context, int res)                         :string.xml中的文案（R.string.xxx）
     
#### AppUtil

    getAppName                                                   :获取应用程序名称
    getVersionName                                               :当前应用的版本名称
    getVersionCode                                               :获取应用程版本号
    getPackageName                                               :获取应用程序包名
    getAppLogo                                                   :获取应用程序图标
    
#### DateUtil

    getDateAndWeek(String style)                                 :获取当天的日期和星期（2018年1月1日 星期一）
    getDateAndTime(String style)                                 :获取当天的日期和时间（格式与传入的格式一致，如yyyy-MM-dd HH:mm:ss）
    getDateAndTime(String style, long time)                      :获取某一天的日期和时间（格式与传入的格式一致，如yyyy-MM-dd HH:mm:ss）
    getWeek()                                                    :获取当天的星期   
    getWeekOfOneDay(String date)                                 :获取某一天的星期 
    getSingleDate(String type)                                   :获取当天单独的年月日时分秒       
    getSingleDate1(long time, String type)                       :获取某一天单独的年月日时分秒  
    dateToString(Date data, String formatType)                   :date类型转换为String类型
    longToString(long currentTime, String formatType)            :long类型转换为String类型 
    stringToDate(String strTime, String formatType)              :string类型转换为date类型 
    longToDate(long currentTime, String formatType)              :long转换为Date类型 
    stringToLong(String strTime, String formatType)              :string类型转换为long类型
    dateToLong(Date date)                                        :date类型转换为long类型
    
#### MoneyUtil

    formatMoney(String value)                                    :格式化金额
    moneyAdd(String valueStr, String addStr)                     :金额相加
    moneyAdd(BigDecimal value, BigDecimal augend)                :金额相加
    moneySub(String valueStr, String minusStr)                   :金额相减
    moneySub(BigDecimal value, BigDecimal subtrahend)            :金额相减
    moneyMul(String valueStr, String mulStr)                     :金额相乘
    moneyMul(BigDecimal value, BigDecimal mulValue)              :金额相乘
    moneydiv(String valueStr, String divideStr)                  :金额相除
    moneydiv(BigDecimal value, BigDecimal divideValue)           :金额相除
    moneyComp(String valueStr, String compValueStr)              :金额比较（valueStr>=compValueStr，则return true 反之return false）
    moneyComp(BigDecimal valueStr, BigDecimal compValueStr)      :金额比较（valueStr>=compValueStr，则return true 反之return false）
    setScaleMyself(BigDecimal bigDecimal)                        :格式化金额，保留两位小数
    getProgress(double bigDecimal)                               :获取百分比，保留两位小数

#### SoftInputUtil

    showSoftInput(Context context)                               :显示软键盘
    showSoftInput(Context context, View view)                    :显示软键盘
    hideSoftInput(Context context, View view)                    :隐藏软键盘
    
#### SpannableUtil

    参数说明：
    context：       上下文
    textView：      要设置文字的textView
    str：           要设置的文字
    startIndex：    要设置字符串的开始位置
    endIndex：      要设置字符串的结束位置
    colorRes：      颜色的资源文件（如：R.color.red）
    clickableSpan： 点击事件的回调
    textSize：      字体的大小
    typeface：     正常：Typeface.NORMAL == 0 ，粗体：Typeface.BOLD == 1 ，
                   斜体：Typeface.ITALIC == 2 ，粗斜体：Typeface.BOLD_ITALIC == 3
    urlStr：       要跳转的URL
      
    方法说明：
    setForegroundColor                                          :设置某些文字颜色 
    setBackgroundColor                                          :设置某些文字的背景颜色 
    setClickableSpan                                            :设置某些文字的点击事件
    setBlurMaskFilter                                           :设置某些文字的模糊效果 
    setStrikethroughSpan                                        :设置某些文字的删除线效果 
    setUnderlineSpan                                            :设置某些文字的下滑线效果 
    setAbsoluteSizeSpan                                         :设置某些文字的绝对大小效果
    setRelativeSizeSpan                                         :设置某些文字的相对大小效果
    setStyleSpan                                                :设置某些文字的粗体、斜体等
    setURLSpan                                                  :设置某些文字的链接
    setSuperscriptSpan                                          :设置某些文字的上标
    setSubscriptSpan                                            :设置某些文字的下标 
    
#### VerificationUtil

    checkMobilePhoneNumber(String phoneNumber)                 :验证手机号  
    checkEmail(String email)                                   :验证Email
    checkIdCard(String idCard)                                 :模糊验证身份证号码（包含18位和15位）
    checkIDCard(String idCard)                                 :精确验证18位身份证号码
    checkPhone(String phone)                                   :验证固定电话号码
    checkURL(String url)                                       :验证URL地址
    checkIpAddress(String ipAddress)                           :匹配IP地址(简单匹配，格式，如：192.168.1.1，127.0.0.1，没有匹配IP段的大小)
    checkPostcode(String postcode)                             :匹配中国邮政编码
    checkDigit(String digit)                                   :验证整数（正整数和负整数）
    checkDecimals(String decimals)                             :验证整数和浮点数（正负整数和正负浮点数）
    checkBlankSpace(String blankSpace)                         :验证空白字符
    checkChinese(String chinese)                               :验证中文
    checkBirthday(String birthday)                             :验证日期（年月日）
    checkStr2Dou(String str)                                   :验证一个字符串是否可以转换为Double类型
    checkStr2Int(String str)                                   :验证一个字符串是否可以转换为int类型