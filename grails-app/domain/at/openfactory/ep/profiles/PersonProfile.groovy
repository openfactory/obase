package at.openfactory.ep.profiles

public class PersonProfile extends GenericProfile
{
  static final int GENDER_MALE = 1
  static final int GENDER_FEMALE = 2
  static final int GENDER_FAMILY = 3
  static final int GENDER_COMPANY = 4

  int  gender
  Date birthday

  String status
  String location
  String profession
  String hobbies
  String webSite

  static constraints = {
    status      nullable: true
    location    nullable: true
    profession  nullable: true
    hobbies     nullable: true
    birthday    nullable: true
    webSite     nullable: true
  }

}