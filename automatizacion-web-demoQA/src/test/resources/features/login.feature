
Feature: Login

  @test1
  Scenario: Crear nuevo usuario
    Given me encuentro en la pàgina principal de demoqa
    And se da click en Book Store Application
    And se da click en Login y New User
    When ingreso en First Name: "Diego",Last Name: "Huayta"
    And UserName: "User001" y Password: "User001%%"
    And se da click en I'm not a robot y Register
    Then aparece un mensaje con la confirmación exitosa