Feature: Compra de un articulo con Tarjeta de Credito
  Yo como usuario de la tienda DemoGuru99
  Quiero comprar un articulo con una tarjeta de credito
  Para ahorrar tiempo en hacer un tramite personal

  @Carrito
  Scenario: Compro una sola vez
    Given la pagina DemoGuru esta disponible
    When doy click en generar tarjeta
    And capturo los datos de la tarjeta
    And selecciono una cantidad de productos al carritos y le doy comprar
    Then ingreso los datos de la tarjeta