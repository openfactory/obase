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


      "/start/$id?" {
        controller = "dashboard"
      }

	  "/login/$action?/$id?" {
		controller = "login"
	  }

	  "/logout" {
		  controller = "logout"
      action = "index"
	  }


      "/admin/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }
      "/"(view:"/index")
	  "500"(view:'/error')
	}
}
