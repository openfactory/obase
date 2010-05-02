class UrlMappings {
    static mappings = {
      "/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
          }
      }

      "/a/get/$entity/$type/$select?" {
        controller = "asset"
        action = 'get'
      }


      "/"(view:"/index")
	  "500"(view:'/error')
	}
}
