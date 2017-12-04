package work.johntsai.kotgank.model


data class GankDataModelWrapper<out T>(val error: Boolean, val results: List<T>)