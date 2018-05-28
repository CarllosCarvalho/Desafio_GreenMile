Feature: GreenMile Register Question Feature

Scenario: Register Question Happy Day

Given User access to SmartSurvey functionality
When Button to register question and visible
Then user click in NEW for Register Question
Then user fill in the fields Description and Organization
Then user click in ADD APPLICATION RULES
Then user click in SAVE
Then user fill in the field Title
Then user click in ADD QUESTION
Then user click in any question section
Then user fill in the required fields
Then user click in SAVE Questions
Then user verify register Question