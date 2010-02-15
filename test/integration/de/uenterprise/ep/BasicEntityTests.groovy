package de.uenterprise.ep

import grails.test.*

class BasicEntityTests extends GrailsUnitTestCase {
    def messageSource ;

    EntityType krochaType
    EntitySuperType personSuperType

    protected void setUp() {
        log.info("setting up basic entity tests...")
        personSuperType = EntitySuperType.findByName('Person')
        assertNotNull("supertype setup failure", personSuperType)

        krochaType = EntityType.findByName ("Krocher")
        assertNotNull("type setup failure", krochaType)


        log.info ("setting up basic entity test complete.")
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }



  /**
   * creates an entity with the minimum number of attributes
   */
    void testCreateMinimalEntity () {
      Entity e = new Entity (name:'hugo', type:krochaType)
      assert e.save()

      assertNotNull e.id
      assertNotNull e.type
      assertNull e.user
      assertNull e.profile

      assertEquals e.type.name, "Krocher"
      assertEquals e.type.supertype.name, "Person"
    }

  /**
   * creates an entry with an valid user
   */
  void testCreateEntryWithUser () {
    Account hugoUser = new Account (email:"hugo@franzfranz.at")
    Entity e = new Entity (name:'hugo', type:krochaType, user:hugoUser)

    if (!e.validate()) {
      e.errors.allErrors.each {
        log.info ("==> validation error: field: '$it.field' code: $it.code, rejectedValue: $it.rejectedValue")
      }
      fail ("validation errors occured. see log for details")
    }

    assertNotNull e.save()

    assertNotNull e.id
    assertNotNull e.user
    assertNotNull e.user.id
    assertNotNull e.user.email
    assertTrue    e.user.is (hugoUser)
    assertTrue    e.user.entity.is(e)
  }

  /**
   * create an entity with a profile
   */
  void testCreateEntryWithProfile () {
    Profile hugoProfile = new Profile (fullName:"Hugo Wiener", tagline:"Das Leben ist eine Tragödie - zusammengestellt aus vielen Komödien")
    Entity e = new Entity (name:'hugo', type:krochaType, profile:hugoProfile)

    if (!e.validate()) {
      e.errors.allErrors.each {
        log.info ("==> validation error: field: '$it.field' code: $it.code, rejectedValue: $it.rejectedValue")
      }
      fail ("validation errors occured. see log for details")
    }

    assertNotNull e.save()

    assertNotNull e.id
    assertNotNull e.profile
    assertNotNull e.profile.id
    assertNotNull e.profile.fullName
    assertNotNull e.profile.tagline
    assertTrue    e.profile.is (hugoProfile)
    assertTrue    e.profile.entity.is(e)
  }


  /**
   * creates an entity w/o type
   */
  void testCreateInvalidEntity1() {
    Entity e = new Entity (name:'hugo')

    assertFalse e.validate()
    def errors = e.errors

    assertTrue e.hasErrors()
    errors.allErrors.each {
      log.info ("==> validation error: field: '$it.field' code: $it.code, rejectedValue: $it.rejectedValue")
    }
    assertEquals "nullable",errors.getFieldError("type").code
  }


}
