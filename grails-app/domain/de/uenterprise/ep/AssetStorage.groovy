package de.uenterprise.ep

class AssetStorage {
    static hasMany = [assets:Asset]

    String storageId
    String contentType


    static constraints = {
    }
}
