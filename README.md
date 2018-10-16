# UtilsLibrary
Android开发过程中常用的工具类

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
