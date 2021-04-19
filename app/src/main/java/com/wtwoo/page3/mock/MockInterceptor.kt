package com.wtwoo.page3.mock

import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import timber.log.Timber

class MockInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val uri = chain.request().url.toUri().toString()
        val encodedPath = chain.request().url.encodedPath

        val responseString = when {
            encodedPath.endsWith("popular") -> getTestJson
            else -> ""
        }

        Timber.d("MockInterceptor intercept uri: $uri")
        Timber.d("MockInterceptor responseString: $responseString")
        if (responseString.isEmpty()) return chain.proceed(chain.request())

        val responseBody = responseString.toByteArray().toResponseBody(
            "application/json".toMediaTypeOrNull()
        )

        Timber.d("MockInterceptor responseString: $responseString")

        return chain.proceed(chain.request())
            .newBuilder()
            .code(200)
            .protocol(Protocol.HTTP_2)
            .message(responseString)
            .body(responseBody)
            .addHeader("content-type", "application/json")
            .build()
    }
}

const val getTestJson = """
{
    "page": 1,
    "results": [
        {
            "adult": false,
            "backdrop_path": "/inJjDhCjfhh3RtrJWBmmDqeuSYC.jpg",
            "genre_ids": [
                28,
                878
            ],
            "id": 399566,
            "original_language": "en",
            "original_title": "Godzilla vs. Kong",
            "overview": "콩과 보호자들은 정착할 수 있는 곳을 찾아 특별하고 강력한 유대감을 형성하고 있는 지아와 함께 여정을 떠나게 된다. 그러던 중 지구 파괴를 위한 회심의 날을 휘두르는 고질라와 마주하게 되고, 보이지 않는 힘에 의해 맞붙게 된 두 전설의 대결은 지구 깊은 곳에 도사린 수수께끼의 시작에 불과할 뿐이었는데…",
            "popularity": 6065.197,
            "poster_path": "https://i.pinimg.com/originals/52/c7/ab/52c7ab7f3825f0b804555681b7c6098b.jpg",
            "release_date": "2021-03-24",
            "title": "고질라 VS. 콩",
            "video": false,
            "vote_average": 8.3,
            "vote_count": 4552
        },
        {
            "adult": false,
            "backdrop_path": "/pcDc2WJAYGJTTvRSEIpRZwM3Ola.jpg",
            "genre_ids": [
                28,
                12,
                14,
                878
            ],
            "id": 791373,
            "original_language": "en",
            "original_title": "Zack Snyder's Justice League",
            "overview": "슈퍼맨이 죽고 지구에 어둠의 그림자가 드리운다. 마더박스를 차지하기 위해 빌런 스테픈울프가 파라데몬 군단을 이끌고 지구에 온 것이다. 지구를 지키기 위해 목숨을 바친 슈퍼맨의 희생이 헛되지 않도록 하기 위해 브루스 웨인은 다이애나 프린스와 적에 맞서기로 한다. 배트맨과 원더 우먼은 새로이 등장한 위협에 맞서 싸우기 위해 특별한 능력을 가진 메타휴먼, 아쿠아맨과 사이보그, 플래시를 찾아가 설득하여 힘을 합친다. 드디어 한 팀이 된 저스티스 리그. 혹시 스테픈울프와 데사드 그리고 다크사이드를 물리치기에 너무 늦어버린 것이 아닐까?",
            "popularity": 3096.436,
            "poster_path": "/qd7iPB26bwMPZqRcnflzAeDkMn.jpg",
            "release_date": "2021-03-18",
            "title": "잭 스나이더의 저스티스 리그",
            "video": false,
            "vote_average": 8.5,
            "vote_count": 4962
        },
        {
            "adult": false,
            "backdrop_path": "/5NxjLfs7Bi07bfZCRl9CCnUw7AA.jpg",
            "genre_ids": [
                878,
                28,
                12,
                53
            ],
            "id": 412656,
            "original_language": "en",
            "original_title": "Chaos Walking",
            "overview": "모든 생각이 실시간으로 노출되는 노이즈에 감염된 세상 뉴 월드. 토드는 이곳에 불시착한 의문의 유입자 바이올라와 마주하게 된다. 혼돈의 세상 속 숨겨진 비밀에 의문을 품은 두 사람은 뉴 월드를 탈출할 계획을 세우고, 뉴 월드의 통치자 데이비드는 위험을 직감하고 이들을 추격하기 위해 모든 수단을 동원하는데…",
            "popularity": 2312.529,
            "poster_path": "/jlmuSzTXOppShgYZbeetWTFTi6P.jpg",
            "release_date": "2021-02-24",
            "title": "카오스 워킹",
            "video": false,
            "vote_average": 7.4,
            "vote_count": 382
        },
        {
            "adult": false,
            "backdrop_path": "/9yBVqNruk6Ykrwc32qrK2TIE5xw.jpg",
            "genre_ids": [
                14,
                28,
                12
            ],
            "id": 460465,
            "original_language": "en",
            "original_title": "Mortal Kombat",
            "overview": "어스렐름와 아웃월드의 최강 챔피언들이 지구의 운명을 걸고 벌이는 서바이벌 대혈전 모탈 컴뱃. MMA 격투 선수 콜 영은 대전을 앞두고 선택 받은 전사들을 사전에 제거하려는 서브제로의 공격을 받는다. 지구와 가족을 보호하고 자기 혈통의 비밀을 알아내기 위해 모탈 컴뱃 토너먼트에 참가해 죽음의 전투를 치러야 한다!",
            "popularity": 2301.309,
            "poster_path": "/yvcNQv8fth51nWuaLwfpr50IRiO.jpg",
            "release_date": "2021-04-07",
            "title": "모탈 컴뱃",
            "video": false,
            "vote_average": 7.6,
            "vote_count": 52
        },
        {
            "adult": false,
            "backdrop_path": "/7prYzufdIOy1KCTZKVWpjBFqqNr.jpg",
            "genre_ids": [
                16,
                12,
                14,
                10751,
                28
            ],
            "id": 527774,
            "original_language": "en",
            "original_title": "Raya and the Last Dragon",
            "overview": "인간과 드래곤이 평화롭게 공존하던 신비의 땅, 쿠만드라 왕국. 악의 세력 드룬이 들이닥치자, 드래곤들은 인간을 구하기 위해 스스로를 희생하고 사라진다. 500년 후 부활한 드룬이 세상을 공포에 빠뜨리자, 전사 라야는 분열된 쿠만드라를 구하기 위해 전설 속 마지막 드래곤을 찾아 모험을 떠난다. 라야는 험난한 여정을 겪으며 세상을 구하기 위해서는 전설 속 드래곤보다 더 중요한 것이 있다는 것을 깨닫게 되는데…",
            "popularity": 1895.918,
            "poster_path": "/VierXpXqiLK5mRY2FWoVXOYquh.jpg",
            "release_date": "2021-03-03",
            "title": "라야와 마지막 드래곤",
            "video": false,
            "vote_average": 8.3,
            "vote_count": 2308
        },
        {
            "adult": false,
            "backdrop_path": "/9xeEGUZjgiKlI69jwIOi0hjKUIk.jpg",
            "genre_ids": [
                16,
                28,
                14
            ],
            "id": 664767,
            "original_language": "en",
            "original_title": "Mortal Kombat Legends: Scorpion's Revenge",
            "overview": "한 세대에 한 번 꼴로 개최되는 외계와 지구의 챔피언들 간의 토너먼트를 통해 세계의 운명을 결정짓게 되는 이야기. 지구의 수호자인 라이덴 경은 지구에서 가장 강력한 파이터들을 모아 최후의 대결인, 모탈 컴뱃에서 사악한 빌런 상췡으로부터 지구를 지켜야 하는데...",
            "popularity": 1432.778,
            "poster_path": "/4VlXER3FImHeFuUjBShFamhIp9M.jpg",
            "release_date": "2020-04-12",
            "title": "모탈 컴뱃 레전드: 스콜피온의 복수",
            "video": false,
            "vote_average": 8.4,
            "vote_count": 845
        },
        {
            "adult": false,
            "backdrop_path": "/z7HLq35df6ZpRxdMAE0qE3Ge4SJ.jpg",
            "genre_ids": [
                28,
                12,
                35,
                14
            ],
            "id": 615678,
            "original_language": "en",
            "original_title": "Thunder Force",
            "overview": "초능력을 가진 악당들을 소탕하라. 사이가 소원해진 두 친구가 도시의 수호자로 나선다. 계획에 없던 슈퍼 팀이지만 싸워보자고, 친구!",
            "popularity": 1197.346,
            "poster_path": "/oJ9BWm2wWlkuKWAZOwIRIHgxAJo.jpg",
            "release_date": "2021-04-09",
            "title": "썬더 포스",
            "video": false,
            "vote_average": 5.8,
            "vote_count": 320
        },
        {
            "adult": false,
            "backdrop_path": "/z8TvnEVRenMSTemxYZwLGqFofgF.jpg",
            "genre_ids": [
                14,
                28,
                12
            ],
            "id": 458576,
            "original_language": "en",
            "original_title": "Monster Hunter",
            "overview": "UN합동 보안 작전부 아르테미스 대위(밀라 요보비치)는 행방불명된 팀원들을 찾기 위해 나서지만 실종된 그들과 같은 이상 현상으로 거대 몬스터의 세계로 빠진다. 하지만 눈앞에 닥친 강력한 몬스터들의 습격으로 유일한 생존자가 된 그녀는 몬스터 헌터(토니 자)와 마주하게 되는데… 다시 인류의 세계로 돌아갈 수 있는 방법은 단 하나. 몬스터와 맞서 반드시 살아남아야 한다!",
            "popularity": 1190.588,
            "poster_path": "/eEmyuyNg4A3LEntaPrUiMueWtLA.jpg",
            "release_date": "2020-12-03",
            "title": "몬스터 헌터",
            "video": false,
            "vote_average": 7.1,
            "vote_count": 1466
        },
        {
            "adult": false,
            "backdrop_path": "/jnq4fV53Px9HvUZD2bQIxtGSwS7.jpg",
            "genre_ids": [
                80,
                18,
                28
            ],
            "id": 644083,
            "original_language": "en",
            "original_title": "Twist",
            "overview": "",
            "popularity": 1321.171,
            "poster_path": "/29dCusd9PwHrbDqzxNG35WcpZpS.jpg",
            "release_date": "2021-01-22",
            "title": "트위스트",
            "video": false,
            "vote_average": 7.1,
            "vote_count": 38
        },
        {
            "adult": false,
            "backdrop_path": "/uQtqiAu2bBlokqjlURVLEha6zoi.jpg",
            "genre_ids": [
                80,
                18
            ],
            "id": 544401,
            "original_language": "en",
            "original_title": "Cherry",
            "overview": "이라크 전쟁 참전 후 PTSD를 겪으며 약물 중독과 은행강도에 손을 댄 군인의 이야기",
            "popularity": 1169.401,
            "poster_path": "/pwDvkDyaHEU9V7cApQhbcSJMG1w.jpg",
            "release_date": "2021-02-26",
            "title": "체리",
            "video": false,
            "vote_average": 7.6,
            "vote_count": 510
        },
        {
            "adult": false,
            "backdrop_path": "/fev8UFNFFYsD5q7AcYS8LyTzqwl.jpg",
            "genre_ids": [
                35,
                10751,
                16
            ],
            "id": 587807,
            "original_language": "en",
            "original_title": "Tom & Jerry",
            "overview": "생쥐 제리는 성대한 결혼식이 열리게 될 뉴욕의 한 고급 호텔로 이사를 오게 되고, 이벤트 플래너 카일라는 제리를 잡기 위해서 고양이 톰을 고용한다. 하지만 우당탕탕 사고뭉치들의 역대급 대소동은 카일라의 커리어는 물론 결혼식과 호텔까지도 위험에 빠뜨리게 되는데…",
            "popularity": 1255.819,
            "poster_path": "/rYoITBMgw14m4cucXNOAw3qBS6c.jpg",
            "release_date": "2021-02-11",
            "title": "톰과 제리",
            "video": false,
            "vote_average": 7.3,
            "vote_count": 1206
        },
        {
            "adult": false,
            "backdrop_path": "/gzJnMEMkHowkUndn9gCr8ghQPzN.jpg",
            "genre_ids": [
                53,
                28,
                18
            ],
            "id": 793723,
            "original_language": "fr",
            "original_title": "Sentinelle",
            "overview": "상처는 한 번이면 충분하다. 중동에서 군사 작전 중 트라우마를 입고 귀국한 클라라. 하지만 불온한 지중해의 공기는 그녀를 치유해 주지 못하는데. 가족이 다치고 평화에 균열이 생기는 순간, 훈련된 전사의 본능이 눈을 뜬다.",
            "popularity": 1157.37,
            "poster_path": "/AmUGn1rJ9XDDP6DYn9OA2uV8MIg.jpg",
            "release_date": "2021-03-05",
            "title": "상티넬",
            "video": false,
            "vote_average": 6,
            "vote_count": 335
        },
        {
            "adult": false,
            "backdrop_path": "/srYya1ZlI97Au4jUYAktDe3avyA.jpg",
            "genre_ids": [
                14,
                28,
                12
            ],
            "id": 464052,
            "original_language": "en",
            "original_title": "Wonder Woman 1984",
            "overview": "사랑의 힘으로 시련을 딛고 진정한 슈퍼히어로로 거듭난 원더 우먼 다이애나 프린스는 고고학자로서 인간들 사이에서 조용히 살고 있다. 다이애나의 마음 한편엔 세상을 떠난 연인 스티브 트레버의 빈자리가 여전하다. 그녀의 주변이 어수선해지기 시작한 건 동료 바바라가 관리 중이던 고대 유물을 수상한 석유 부자 맥스 로드에게 맡기고서부터. 사람들의 소원을 들어주는 대가로 그들에게서 가장 소중한 것을 앗아가는 빌런이 세상을 어지럽히기 시작하고, 다이애나의 앞엔 거짓말처럼 죽었던 스티브가 나타나는데...",
            "popularity": 1076.442,
            "poster_path": "/ss6A2u6YiHTEWeVR01GtTUoO2Xj.jpg",
            "release_date": "2020-12-16",
            "title": "원더 우먼 1984",
            "video": false,
            "vote_average": 6.8,
            "vote_count": 4860
        },
        {
            "adult": false,
            "backdrop_path": "/drulhSX7P5TQlEMQZ3JoXKSDEfz.jpg",
            "genre_ids": [
                18,
                14,
                878
            ],
            "id": 581389,
            "original_language": "ko",
            "original_title": "승리호",
            "overview": "2092년, 지구는 병들고 우주 위성궤도에 인류의 새로운 보금자리인 UTS가 만들어졌다. 돈 되는 일이라면 뭐든 하는 조종사 태호, 과거 우주 해적단을 이끌었던 장선장, 갱단 두목이었지만 이제는 기관사가 된 타이거 박, 평생 이루고 싶은 꿈을 가진 작살잡이 로봇 업동이, 이들은 우주쓰레기를 주워 돈을 버는 청소선 승리호의 선원들이다. 어느 날 사고 우주정을 수거한 승리호는 그 안에 숨어있던 대량살상무기로 알려진 인간형 로봇 도로시를 발견한다. 돈이 절실한 선원들은 도로시를 거액의 돈과 맞바꾸기 위한 위험한 거래를 계획하는데...",
            "popularity": 947.773,
            "poster_path": "/vOefWMYqC1S3aiCTD5MD8HeXl0Y.jpg",
            "release_date": "2021-02-05",
            "title": "승리호",
            "video": false,
            "vote_average": 7.2,
            "vote_count": 495
        },
        {
            "adult": false,
            "backdrop_path": "/6TPZSJ06OEXeelx1U1VIAt0j9Ry.jpg",
            "genre_ids": [
                28,
                80,
                53
            ],
            "id": 587996,
            "original_language": "es",
            "original_title": "Bajocero",
            "overview": "혹한의 밤 산간 도로를 달리던 죄수 호송 차량이 불의의 습격을 당한다. 겨우 살아남지만 재소자들과 차량에 갇힌 경관 마르틴. 차 안에는 탈출을 감행하려는 재소자들이, 밖에는 정체불명의 공격자가 도사리고 있다. 어떻게 벗어날 것인가.",
            "popularity": 1085.702,
            "poster_path": "/4SEAkDj7nflDPqCwD1LxrGkldTt.jpg",
            "release_date": "2021-01-29",
            "title": "빌로우제로",
            "video": false,
            "vote_average": 6.4,
            "vote_count": 515
        },
        {
            "adult": false,
            "backdrop_path": "/zDq2pwPyt4xwSFHKUoNN2LohDWj.jpg",
            "genre_ids": [
                27
            ],
            "id": 632357,
            "original_language": "en",
            "original_title": "The Unholy",
            "overview": "",
            "popularity": 798.655,
            "poster_path": "/b4gYVcl8pParX8AjkN90iQrWrWO.jpg",
            "release_date": "2021-03-31",
            "title": "언홀리",
            "video": false,
            "vote_average": 5.8,
            "vote_count": 31
        },
        {
            "adult": false,
            "backdrop_path": "/lOSdUkGQmbAl5JQ3QoHqBZUbZhC.jpg",
            "genre_ids": [
                53,
                28,
                878,
                14
            ],
            "id": 775996,
            "original_language": "en",
            "original_title": "Outside the Wire",
            "overview": "가까운 미래 치열한 접전 지역. 드론 조종사가 원치 않게 이곳에 파견된다. 그의 지휘관은 기밀 속 존재인 사이보그. 둘은 함께 핵 공격을 막는 위험한 임무에 뛰어든다.",
            "popularity": 948.023,
            "poster_path": "/gGkFDz4waJJqdrnGhnaUVZZHPHR.jpg",
            "release_date": "2021-01-15",
            "title": "아웃사이드 더 와이어",
            "video": false,
            "vote_average": 6.5,
            "vote_count": 986
        },
        {
            "adult": false,
            "backdrop_path": "/jw0849O7WLarbYKJkA9WpRLeGKG.jpg",
            "genre_ids": [
                35,
                10749
            ],
            "id": 802504,
            "original_language": "nl",
            "original_title": "Just Say Yes",
            "overview": "로맨스 없인 못 사는 로터. 완벽한 결혼식을 준비했건만 갑자기 파혼당한다. 게다가 SNS 없인 못 사는 동생이 로터의 상사와 약혼해 언니의 결혼식 계획을 냉큼 훔치기까지. 이제 로터의 목표는 새 동료와 손잡고 전 남친을 되찾는 것.",
            "popularity": 792.349,
            "poster_path": "/rHfYTIPjSiameKP8zJCQscEJ5wo.jpg",
            "release_date": "2021-04-02",
            "title": "저스트 세이 예스",
            "video": false,
            "vote_average": 5.9,
            "vote_count": 67
        },
        {
            "adult": false,
            "backdrop_path": "/9Is9OrQUnKczCfsLSbsbx8YSmES.jpg",
            "genre_ids": [
                16,
                35,
                14
            ],
            "id": 797394,
            "original_language": "ru",
            "original_title": "Ганзель, Гретель и Агентство Магии",
            "overview": "동화 속의 헨젤과 그레텔은 잊어라. 이제는 특수 요원 헨젤과 그레텔! 사라진 왕을 찾으려면 무엇이 필요할까? 진정한 마법과 영리한 두뇌, 무엇보다 믿음직한 파트너지!",
            "popularity": 815.841,
            "poster_path": "/14FU3Ah6lDrIPLvP2bvyDODuWXn.jpg",
            "release_date": "2021-03-18",
            "title": "마법 관리국과 비밀 요원들",
            "video": false,
            "vote_average": 7.1,
            "vote_count": 102
        },
        {
            "adult": false,
            "backdrop_path": "/fRrpOILyXuWaWLmqF7kXeMVwITQ.jpg",
            "genre_ids": [
                27,
                53,
                12,
                9648
            ],
            "id": 522444,
            "original_language": "en",
            "original_title": "Black Water: Abyss",
            "overview": "에릭-젠과 빅터-욜란다 커플은 친구 캐시가 최근에 발견한 동굴탐험에 함께 참가한다. 그렇게 시작한 탐험은 넓은 공간과 함께 물이 모인곳은 찾게 된다. 주변을 살피던중 갑작스러운 물의 유입으로 고립에 위험에 쳐하게 된다. 그리고, 물속에 악어가 있는걸 확인하게 되는데...",
            "popularity": 825.745,
            "poster_path": "/95S6PinQIvVe4uJAd82a2iGZ0rA.jpg",
            "release_date": "2020-07-09",
            "title": "블랙 워터: 아비스",
            "video": false,
            "vote_average": 4.9,
            "vote_count": 196
        }
    ],
    "total_pages": 500,
    "total_results": 10000
}
"""