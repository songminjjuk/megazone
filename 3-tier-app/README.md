# jenkins_ecs
CI/CD configuration with ECS using Jenkins
![image](https://github.com/user-attachments/assets/a0646584-bc7a-4ccb-b584-7e07a5a40cc4)

## 개요
frontend 폴더 안에 있는 React app의 소스 코드가 변경이 되면, 이를 감지해서 Jenkins 서버로 trigger를 하여 react-pipeline을 실행
backend 폴더 안에 있는 Spring app의 소스 코드가 변경이 되면, 이를 감지해서 Jenkins 서버로 trigger를 하여 spring-pipeline을 실행

## 구분 이유
github_webhook을 이용하지 않고 별도의 workflow 파일을 작성하여 trigger를 보내게 한 이유는 react 소스 코드만 변경이 되었을 때는 spring 소스 코드를 빌드할 필요 x
마찬가지로, spring 소스 코드만 변경이 되었을 때는 react 소스 코드를 빌드할 필요 x
이를 구분하기 위해서 github repository 단위로 hook을 보내는 github_webhook 말고 workflow 파일을 작성하여 별도로 trigger를 보내주게 구성함 

## 최종 구성
최종적으로 github에 변경된 소스 코드를 push하게 되면, workflow가 실행되어 jenkins 서버를 trigger하게 됨 jenkins pipeline에선 변경된 소스 코드를 기반으로 docker image를 만들고 ecr로 push를 하기 위한 tag를 달고 ecr repository까지 빌드 된 이미지를 push를 하게 됨 이 이미지를 기반으로 현재 띄워져있는 ecs task를 롤링 업데이트 방식으로 컨테이너를 갈아 끼우는 작업까지 자동화를 구현함
