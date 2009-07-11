package de.uenterprise.ep

import org.springframework.web.multipart.MultipartFile

class AssetController {
    def assetService
    def entityHelperService
    def index = { }

  static navigation = [group:'main',
                          order:30, title:'Upload Assets', action:'upload',
  ]


    def get = {
      def bytes = new File("c:/temp/JuliusMeinlLogo.png").readBytes()

      response.contentType = "image/png"
      response.outputStream << bytes
      response.outputStream.flush ()
    }

    def put = {
      if (!entityHelperService.loggedIn)
        redirect (controller:'login', action:'denied')

      MultipartFile asset = request.getFile ('asset')
      if (asset && !asset.empty) {
        log.debug ("uploaded asset name:'$asset.name', size:'$asset.size', content:'$asset.contentType' ")
        log.debug ("type: $params.type")

        def result = assetService.storeAsset(entityHelperService.loggedIn, params.type, asset)
        if (!result)
          flash.message = 'uploading the asset went bad somehow'

        [asset:result]
      }
    }

    def upload = {
      if (!entityHelperService.loggedIn)
        redirect (controller:'login', action:'denied')
    }
}
