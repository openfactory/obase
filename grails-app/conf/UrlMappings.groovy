class UrlMappings {
    static mappings = {

      "/a/getstore/$id?" {
        controller = "asset"
        action = 'getstore'
      }

      "/a/get/$entity/$type/$select?" {
        controller = "asset"
        action = 'get'
      }


      "/"(view:"/index")
	  "500"(view:'/error')
	}
}
