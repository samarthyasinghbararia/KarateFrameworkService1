Feature: Controller Tests

  Background:
    Given url 'http://localhost:5000/template'
    * def healthResponse = "OK"
    * def id = 1
    * def incorrectId = 0
    * def idNotFound = "Not Found For Id: " + id
    * def incorrectIdNotFound = "Not Found For Id: " + incorrectId
    * def message = "Hello Karate Framework"
    * def updatedMessage = message + " - Updated Message"
    * def postRequestData =
    """
    {
      message: '#(message)'
    }
    """
    * def putRequestData =
    """
    {
      id: '#(id)',
      message: '#(updatedMessage)'
    }
    """
    * def incorrectPutRequestData =
    """
    {
      id: '#(incorrectId)',
      message: '#(updatedMessage)'
    }
    """
    * def createdResponseData =
    """
    {
      id: '#(id)',
      message: '#(message)'
    }
    """
    * def modifiedResponseData =
    """
    {
      id: '#(id)',
      message: '#(updatedMessage)'
    }
    """

  Scenario: Test Get Health With Unsupported Method
    Given path '/health'
    When method POST
    Then status 405

  Scenario: Test Get Health
    Given path '/health'
    When method GET
    Then status 200
    * match response == healthResponse

  Scenario: Test Get Template With Unsupported Method
    Given path '/' + id
    When method POST
    Then status 405

  Scenario: Test Get Template By Id Not Found
    Given path '/' + id
    When method GET
    Then status 404
    * match response == idNotFound

  Scenario: Test Post Template With Unsupported Method
    Given path '/'
    When method GET
    * request postRequestData
    When method GET
    Then status 405

  Scenario: Test Post Template
    Given path '/'
    * request postRequestData
    When method POST
    Then status 201
    * match response == createdResponseData

  Scenario: Test Get Template By Id
    Given path '/' + id
    When method GET
    Then status 200
    * match response == createdResponseData

  Scenario: Test Put Template With Unsupported Method
    Given path '/'
    * request putRequestData
    When method GET
    Then status 405

  Scenario: Test Put Template Not Found
    Given path '/'
    * request incorrectPutRequestData
    When method PUT
    Then status 404
    * match response == incorrectIdNotFound

  Scenario: Test Put Template
    Given path '/'
    * request putRequestData
    When method PUT
    Then status 201
    * match response == modifiedResponseData

  Scenario: Test Delete Template Not Found
    Given path '/' + incorrectId
    When method DELETE
    Then status 404
    * match response == incorrectIdNotFound

  Scenario: Test Delete Template
    Given path '/' + id
    When method DELETE
    Then status 200
    * match response == modifiedResponseData
