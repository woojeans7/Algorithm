# 감염된 폴더1

[문제 링크](https://cote.nossi.dev/problem/34/description)

## 성능 요약

메모리: 66.39 MB, 시간 : 20 ms

## 문제 설명

당신은 시스템 보안 엔지니어입니다.

파일 시스템은 트리 구조로 구성되어 있으며, 각 폴더는 하나의 부모 폴더를 갖고, 최상위 폴더는 “root” 입니다.

어느 날 두 개의 하위 폴더에 바이러스가 감염되었다는 사실을 알게 되었습니다.

당신의 임무는 이 바이러스를 제거하는 것인데, 감염된 두 폴더를 모두 포함하는 하나의 상위 폴더를 삭제함으로써 이를 해결할 수 있습니다.

시스템을 최대한 안전하게 유지하기 위해, 삭제 범위를 최소화하고자 합니다.

파일 시스템의 폴더 구조(folders)와 두 감염 폴더의 이름(p, q)이 주어질 때, 이들을 동시에 제거할 수 있는 최소 범위의 상위 폴더 이름을 반환하는 solution 함수를 작성하세요.

단, 두 폴더는 서로 다른 경로에 존재하는 별개의 폴더이며, 동일한 폴더를 두 번 지목하는 경우는 없습니다.

## 입출력 예시

### 예시 1:

입력:

- folders = [["root", "apps"], ["apps", "chrome"], ["apps", "vscode"]]

- p= "chrome"

- q = "vscode"

출력: “apps”

설명: chrome과 vscode는 둘 다 apps 폴더의 자식입니다. 따라서 이 둘을 동시에 제거할 수 있는 최소한의 폴더는 apps입니다.

### 예시 2:

입력:

- folders = [["root", "usr"], ["usr", "bin"], ["usr", "local"], ["bin", "tools"]]

- p = "bin"

- q = "tools”

출력: “bin”

설명: tools는 bin의 자식이며, bin은 자기 자신입니다. 둘을 함께 제거하려면 bin을 삭제하는 것이 가장 최소 범위입니다. 이처럼 공통 조상이 감염된 폴더 중 하나일 수도 있습니다.

### 예시 3:

입력:

- folders = [["root", "media"], ["media", "images"], ["media", "videos"], ["images", "holiday"], ["videos", "concert"]]

- p = "holiday"

- q = "concert"

출력: “media”

설명: holiday는 images의 자식이고, concert는 videos의 자식입니다. 이 둘은 모두 media 폴더 아래에 있으므로, 공통 조상은 media입니다. media만 삭제하면 두 감염 폴더를 모두 제거할 수 있습니다.

## 제한 사항

- 2 ≤ folders.length ≤ 100

- 각 folders[i]는 [상위폴더, 하위폴더] 형식의 문자열 쌍입니다.

- 폴더 이름은 길이가 1 이상 10 이하의 문자열입니다.

- 모든 폴더 이름은 유일(unique) 하며, 중복되지 않습니다.

- 항상 하나의 루트 폴더 "root"가 존재합니다
