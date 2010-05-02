package at.openfactory.ep

import grails.test.*

class EntityHelperServiceTests extends GrailsUnitTestCase {
  def entityHelperService

  def krochaType

  protected void setUp() {
    super.setUp()

    assertNotNull entityHelperService
    krochaType = EntityType.findByName("Krocher")
    assertNotNull("type setup failure", krochaType)

  }

    protected void tearDown() {
        super.tearDown()
    }

    void testCreateEntity () {
      Entity entity = entityHelperService.createEntity ("hugotest", krochaType)

      assertFalse entity.hasErrors()
      assertNotNull entity.id
      assertEquals entity.name, "hugotest"
    }


    void testCreateEntityWithClosure () {
      Entity entity = entityHelperService.createEntity ("hugotest", krochaType) {Entity e->
        e.user = new Account (email:"hugotest@hshsgs.com")
        assertNull e.id // it's not yet persisted
      }

      assertFalse entity.hasErrors()
      assertNotNull entity.id
      assertEquals  entity.name, "hugotest"
      assertNotNull entity.user
      assertEquals  entity.user.email, "hugotest@hshsgs.com"
    }

    void testCreateEntityWithUserAndProfile () {
      Entity entity = entityHelperService.createEntityWithUserAndProfile ("hugotest2", krochaType, "hugotest2@xxx.com", "Otto Testa") {Entity e->
        assertNotNull e.profile
        assertNull    e.profile.id
        e.profile.tagline = "to be on top is our job"
      }

      assertFalse entity.hasErrors()
      assertNotNull entity.id
      assertNotNull entity.profile.fullName
      assertEquals  entity.profile.fullName, "Otto Testa"
      assertNotNull entity.profile.tagline
      assertEquals entity.profile.tagline,"to be on top is our job"
    }

    void testCreateEntityErrNoType () {
      try  {
        Entity entity = entityHelperService.createEntity ("hugotest3", null)
      } catch (EntityException ee) {
        // this is the expeced exception
        assertEquals "nullable",ee.entity.errors.getFieldError("type").code
        return

      } catch (Throwable t) {
        fail ("creating an incomplete entity is supposed to throw an 'EntityException' but actually did throw an $t")

      }
      fail ("creating an entity with an null type is not supposed to be sucessfull")
    }

    void testCreateEntityErrInvProfile () {
      // the profile.fullname has a length constraint which will the call cause to fail
      try  {
        Entity entity = entityHelperService.createEntityWithUserAndProfile ("hugotest4", krochaType, "hugotest4@yyy.com", "HUG")
      } catch (EntityException ee) {
        // this is the expeced exception
        assertNotNull  ee.entity.errors.getFieldError("profile.fullName")
        assertEquals "size.toosmall",ee.entity.errors.getFieldError("profile.fullName").code
        return

      } catch (Throwable t) {
        fail ("creating an incomplete entity is supposed to throw an 'EntityException' but actually did throw an $t")

      }
      fail ("creating an entity with an invalid profile (fullname - size.toosmall) is not supposed to be sucessfull")

    }
}
