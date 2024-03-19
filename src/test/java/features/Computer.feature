Feature: Pagina Principal de Venta electrodomesticos

  Scenario: Visitar opciones que tenga Electronics

    Given entro en la pagina de NoCommerce
    And   voy al link "Electronics"
    When voy a "Camera & photo"
    Then Verifico que hay 3 productos disponibles

    Scenario Outline: Visitar los diferentes Categorias

      Given entro en la pagina de NoCommerce
      When voy a las diferentes "<categorias>"
      Then Obtengo el nombre de todas las que visite
      And Verifico con la cantidad Actual

      Examples:
        | categorias  |
        | Computers   |
        | Electronics |
        | Apparel     |