package backend.prototype

import com.mongodb.client.model.Updates
import org.bson.Document

object DB {
    fun deleteName(name: Name) {
        collection.deleteOne(Document("name", name.name))
    }

    fun getNames(): Names = Names(collection.find().toList().map { it.getString("name") })

    fun updateName(update: NameUpdate) {
        collection.findOneAndUpdate(Document("name", update.oldName), Updates.set("name", update.newName))
    }

    fun insertName(name: Name): Unit = collection.insertOne(Document("name", name.name))
}