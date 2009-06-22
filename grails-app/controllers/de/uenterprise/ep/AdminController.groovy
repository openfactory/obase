package de.uenterprise.ep

class AdminController {
    def authenticateService

    static navigation = [group:'main', order:90, title:'Administration', action:'index',
            isVisible: { authenticateService.ifAllGranted('ROLE_ADMIN')}
    ]


    def index = {
      request.navmenu = 'admin'
      [test:'xxx']
    }

    def test1 = {

    }

    def test2 = {

    }
}
