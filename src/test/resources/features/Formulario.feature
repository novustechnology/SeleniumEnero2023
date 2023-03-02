Feature: Automatización de Formulario

  @Formulario
  Scenario: Ingreso de datos
    Given ingreso a la pagina TutorialsPoint
    And ingreso los datos del formulario
      | firstName | lastName | sex  | yearsExperience | profession        |
      | York      | Correa   | Male | 5               | Automation Tester |
    And cargo una imagen y selecciono el tipo de Selenium "Selenium Webdriver"
    And selecciono el continente "North America" y los comandos de selenium
