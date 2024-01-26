Feature: Plan de Pruebas users


  Background:
    Given url 'https://dev-457931.okta.com/oauth2/aushd4c95QtFHsfWt4x6/v1/token'



    * def credentials = { scope: 'offline_access', grant_type:  'password', username: 'api-user4@iwt.net', password: 'b3z0nV0cLO', client_id: '0oahdhjkutaGcIK2M4x6' }
    And form fields credentials
    When method post
    * def token = response.access_token
    * print "El token es:", token

  @Authorization_1
  Scenario: Authorization airplane data
    Given url 'https://api.instantwebtools.net/v2/airlines/1'
    * header Authorization = 'Bearer ' + token
    When method get
    Then status 200
    * match response.name == "Sri Lankan Airways"
    * print response



"""
 @Register
Scenario: caso de prueba tipo GET
Given url 'https://reqres.in/api/users/2'
    When method GET
And match response.data.first_name == 'Janet'
   Then status 200
  @Register2
  Scenario: caso de prueba tipo POST

   Given url 'https://reqres.in/api/users'
When request {"name":"morpheus","job":"leader"}
    And method POST
    Then status 201

  @Register3
  Scenario: caso de prueba tipo POST Numero 2

Given url 'https://reqres.in/api/users'
When request

{
    "name": "Sandra",
    "job": "QA"
}

  And method POST
  Then status 201

  @Register4
    Scenario: Caso de prueba tipo DELETE

      Given url 'https://reqres.in//api/users/2'
      When method DELETE
      Then status 204

"""

