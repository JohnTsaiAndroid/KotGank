package work.johntsai.kotgank.model

/**
 "_id": "5a137c67421aa90fef20354d",
"createdAt": "2017-11-21T09:07:51.275Z",
"desc": "iOS 和 Android 开发是否要采用 React Native?",
"publishedAt": "2017-11-24T11:08:03.624Z",
"source": "web",
"type": "Android",
"url": "https://mp.weixin.qq.com/s?__biz=MzU4MjAzNTAwMA==&mid=2247483866&idx=1&sn=b5cad7e5c26d001d920b0eff0625a995&key=6571080d88416c7220506cd2febefb7313338d6e5ef958258d4c8740d2dfc118bcca1c3edef0a834a293256d27046ecda4902f4b359f8550d6db0b150d4de080cfb515dbef6bd2654b3e3f35e3a625e7&ascene=0&uin=NTI1MzE1NDE1&devicetype=iMac+MacBookPro12%2C1+OSX+OSX+10.12.6+build(16G29)&version=12020610&nettype=WIFI&fontScale=100&pass_ticket=B5BwzwdLM8k1Q49ldLzImBZOjI9TR1ZOuqEJVskf%2B3xP0nK44%2FBkaEEXGpYDvsxG",
"used": true,
"who": null
 *
 */
data class GankDataModel(val _id:String,val createdAt:String,
                         val desc:String,val publishedAt:String,
                         val source:String,val type:String,
                         val url:String,val who:String){
 override fun toString(): String {
  return "GankDataModel(_id='$_id', createdAt='$createdAt', desc='$desc', publishedAt='$publishedAt', source='$source', type='$type', url='$url', who='$who')"
 }
}

