import at.openfactory.ep.asset.FileSystemByteStore

beans = {
  assetStore (FileSystemByteStore) {bean->
    storeRoot = "c:/temp/ue-assets"
  }
}