package at.openfactory.ep

class AssetStorage {

  static hasMany = [assets: Asset]

  String  storageId
  String  contentType

  static constraints = {
  }

}
