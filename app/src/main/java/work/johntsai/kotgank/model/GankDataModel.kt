package work.johntsai.kotgank.model

data class GankDataModel(val _id: String, val createdAt: String,
                         val desc: String, val publishedAt: String,
                         val source: String, val type: String,
                         val url: String, val who: String) {
    override fun toString(): String {
        return "GankDataModel(_id='$_id', createdAt='$createdAt', desc='$desc', publishedAt='$publishedAt', source='$source', type='$type', url='$url', who='$who')"
    }
}

