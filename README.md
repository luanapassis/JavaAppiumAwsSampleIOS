# JavaAppiumAwsSampleIOS
(IOS) Repositório JAVA do desafio APPIUM + aplicativo de exemplo

- Code Application 
https://github.com/aws-samples/aws-device-farm-sample-app-for-ios

- Building an .app Bundle
    - Open your application project in Xcode.
    - Select your product's device target:
    - On an RDC: Select Generic iOS Device
    - On a simulator: Select any available simulator
    - In the Product menu, select Clean.
    - In the Product menu, select Build.
    - Navigate to your Xcode project's Products directory and find the generated .app file.
    - Create an empty directory with the name Payload.
    - Move the .app file inside the Payload directory.
    - Compress the Payload directory into an archive (.zip file) and give it a new name with .ipa appended to the end of the file name.
    - The .ipa file is now ready for upload to Sauce Labs.