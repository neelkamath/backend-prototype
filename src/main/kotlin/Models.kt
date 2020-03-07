package backend.prototype

data class Name(val name: String)

data class Names(val names: List<String>)

data class NameUpdate(val oldName: String, val newName: String)