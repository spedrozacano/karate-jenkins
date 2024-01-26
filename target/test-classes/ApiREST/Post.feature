Feature: Post endpoint test

  Scenario: Verificar un usuario en especifico

    Given url 'https://jsonplaceholder.typicode.com'
    And path 'posts'
    And param userId = 1
    When method GET
    Then status 200
    And match responseType == 'json'

    ## para imprimir una respuesta

 // * print "RESPONSE:", response [0].userId

