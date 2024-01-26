@soapRequest
Feature: Plan de Pruebas
  Scenario: Caso de prueba tipo POST en SOAP
    Given url 'https://www.dataaccess.com/webservicesserver/NumberConversion.wso'
    When header Content-Type = 'text/xml'
    And request
    """
  <?xml version="1.0" encoding="utf-8"?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
  <soap:Body>
    <NumberToWords xmlns="http://www.dataaccess.com/webservicesserver/">
      <ubiNum>500</ubiNum>
    </NumberToWords>
  </soap:Body>
</soap:Envelope>
    """

    And method POST
    And match response/body/NumbertoWords/ubiNum == 'five hundred '
    Then status 200

