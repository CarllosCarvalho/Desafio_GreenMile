Feature: GreenMile Register Question Mandadoty Fild Error Feature

Scenario: Mandatory Fild Error Register Question

Given User access to SmartSurvey to Simulate Error in Register
When Button to register question and visible for Register
Then user click in NEW to Simulate Error in Register
Then user click in SAVE to Simule Error in Register
Then user verify Error Mesage in register Question