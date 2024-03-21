Feature: Funcionalidades con la tabla del carrito de compra

  @Smoke
  Scenario: LLenar carrito de compra y verificar ela cantidad de filas que tiene la tabla de compra
    Given Estoy en la pagina de Cell phones con productos para agregar al carrito
    When Agrego todos los productos que existen al carrito
    Then Se muestra los productos agregados correctamente
    When  Doy clic en el carrito para verificar mis productos
    Then  Obtengo la cantidad de filas que hay en mii tabla de productos agregados
     And  Obtengo el numero de columnas de m tabla de productos
    And   Obtengo el valor de la primera celda primera columna
