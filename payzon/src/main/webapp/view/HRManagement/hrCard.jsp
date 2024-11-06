<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>人事記録カード</title>

<style>
    /* 레코드 카드 스타일 レコードカードスタイル */
    .record-card {
        width: 50%;
        border-collapse: collapse; /* 테두리 병합 テーブルボーダーの結合 */
    }

    /* 테이블 헤더와 데이터 셀 스타일 テーブルヘッダーとデータセルスタイル */
    .record-card th, .record-card td {
        border: 1px solid #ddd; /* 테두리 색상 ボーダーの色 */
        padding: 8px; /* 패딩 여백 パディング */
    }

    /* 짝수 행 배경색 스타일 偶数行の背景色スタイル */
    .record-card tr:nth-child(even) {
        background-color: #f2f2f2; /* 배경색 背景色 */
    }

    /* 행에 마우스를 올릴 때 배경색 변화 스타일 マウスをホバーした時の行の背景色スタイル */
    .record-card tr:hover {
        background-color: #ddd; /* 배경색 背景色 */
    }

    /* 섹션 제목 스타일 セクションタイトルスタイル */
    .section-title {
        background-color: #4CAF50; /* 배경색 背景色 */
        color: dark; /* 글자 색상 文字の色 */
        text-align: center; /* 가운데 정렬 中央揃え */
    }

    /* 직원 모달 배경 스타일 従業員モーダル背景スタイル */
    .employeeModal {
        display: none; /* 초기에는 숨김 初期には隠す */
        position: fixed; /* 고정 위치 固定位置 */
        z-index: 1000; /* 겹침 순서 重なり順 */
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        overflow: auto; /* 자동 스크롤 自動スクロール */
        background-color: rgba(0, 0, 0, 0.4); /* 반투명 검은색 배경 半透明の黒い背景 */
    }

    /* 모달 창 스타일 モーダルウィンドウスタイル */
    .modal-content {
        position: relative; /* 상대 위치 相対位置 */
        background-color: #fff; /* 배경색 背景色 */
        margin: 10% auto; /* 화면 중앙에 위치 画面中央に位置 */
        padding: 20px; /* 패딩 여백 パディング */
        width: 50%; /* 너비 幅 */
        border-radius: 8px; /* 테두리 둥글게 コーナーを丸くする */
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* 그림자 효과 影の効果 */
    }

    /* 닫기 버튼 스타일 閉じるボタンスタイル */
    .close {
        color: #aaa; /* 색상 色 */
        float: right; /* 오른쪽 정렬 右寄せ */
        font-size: 28px; /* 글자 크기 フォントサイズ */
        font-weight: bold; /* 글자 두께 太字 */
        cursor: pointer; /* 커서 포인터 カーソルポインタ */
    }

    /* 닫기 버튼에 마우스를 올릴 때 스타일 閉じるボタンにマウスをホバーしたときのスタイル */
    .close:hover,
    .close:focus {
        color: #000; /* 글자 색상 文字の色 */
        text-decoration: none; /* 장식 없음 装飾なし */
    }

    /* 테이블 스타일 テーブルスタイル */
    table {
        width: 100%; /* 너비 幅 */
        border-collapse: collapse; /* 테두리 병합 テーブルボーダーの結合 */
        margin-bottom: 20px; /* 아래 여백 下の余白 */
    }

    /* 테이블 헤더와 데이터 셀 기본 스타일 テーブルヘッダーとデータセルの基本スタイル */
    th, td {
        border: 1px solid #ddd; /* 테두리 색상 ボーダーの色 */
        padding: 8px; /* 패딩 여백 パディング */
        text-align: left; /* 왼쪽 정렬 左揃え */
    }

    /* 테이블 헤더 배경색 스타일 テーブルヘッダーの背景色スタイル */
    th {
        background-color: #f2f2f2; /* 배경색 背景色 */
    }

    /* 제목 스타일 タイトルスタイル */
    h1, h2 {
        text-align: center; /* 가운데 정렬 中央揃え */
    }
</style>

</head>
<body>


<form action="hrcard.do" method="post" id="hrCardForm">
    <h1><label>人事記録カード</label></h1> <!-- 인사 기록 카드 / 人事記録カード -->
    <hr>
    
    <button type="button" class="button" onclick="openModal()">全体表示</button> <!-- 전체 표시 버튼 / 全体表示ボタン -->

    <!-- 모달 창 구조 / モーダルウィンドウの構造 -->
    <div id="employeeModal" class="employeeModal">
        <div class="modal-content">
            <span class="close" onclick="closeModal()">&times;</span> <!-- 모달 닫기 버튼 / モーダル閉じるボタン -->
            <h2>人事記録カード社員洗濯</h2> <!-- 인사 기록 카드 직원 선택 / 人事記録カード社員選択 -->
            <c:forEach var="hrCard" items="${hrCardList02}">
                <a href="http://localhost:8282/payzon1/hrcard.do?shain_ID=${hrCard.shain_ID}">
                    ${hrCard.shain_ID} <!-- 직원 ID / 社員ID -->
                </a><br>
            </c:forEach>
        </div>
    </div>

    <!-- hrCardList02 -->
    <c:choose>
        <c:when test="${empty hrCardList02}"> <!-- hrCardList02가 비어있을 경우 / hrCardList02が空の場合 -->
            <p> </p> <!-- 빈 문단 / 空の段落 -->
        </c:when>
        <c:otherwise>
            <table class="record-card"> <!-- 레코드 카드 테이블 / レコードカードテーブル -->
                <tr class="section-title">
                    <th colspan="2">人事記録カード</th> <!-- 인사 기록 카드 / 人事記録カード -->
                </tr>
                <c:forEach var="hrCard" items="${hrCardList02}">
                    <c:if test="${hrCard.shain_ID == 1}"> <!-- shain_ID가 1인 경우 / shain_IDが1の場合 -->
                        <tr>
                            <td>名前（日本語）:</td> <!-- 이름 (일본어) / 名前（日本語） -->
                            <td>${hrCard.shain_namae}</td>
                        </tr>
                        <tr>
                            <td>名前（英語）:</td> <!-- 이름 (영어) / 名前（英語） -->
                            <td>${hrCard.shain_eigo_namae}</td>
                        </tr>
                        <tr>
                            <td>住民番号:</td> <!-- 주민 번호 / 住民番号 -->
                            <td>${hrCard.zyuumin_bangou}</td>
                        </tr>
                        <tr>
                            <td>社員区分:</td> <!-- 고용 형태 / 社員区分 -->
                            <td>${hrCard.koyou_keitai}</td>
                        </tr>
                        <tr>
                            <td>住所:</td> <!-- 주소 / 住所 -->
                            <td>${hrCard.zyuusho}</td>
                        </tr>
                        <tr>
                            <td>携帯電話:</td> <!-- 휴대폰 번호 / 携帯電話 -->
                            <td>${hrCard.keitai_bangou}</td>
                        </tr>
                        <tr>
                            <td>連絡先:</td> <!-- 연락처 / 連絡先 -->
                            <td>${hrCard.denwa_bangou}</td>
                        </tr>
                        <tr>
                            <td>E-Mail:</td> <!-- 이메일 / E-Mail -->
                            <td>${hrCard.meiru_adoresu}</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>

<!-- hrCardList03 -->
<c:choose>
    <c:when test="${empty hrCardList03}">
        <p></p> <!-- 빈 문단 / 空の段落 -->
    </c:when>
    <c:otherwise>
        <table class="record-card">
            <tr class="section-title">
                <th colspan="2">家族事項</th> <!-- 가족 사항 / 家族事項 -->
            </tr>
            <c:forEach var="hrCard" items="${hrCardList03}">
                <c:if test="${hrCard.shain_ID == 1}">
                    <tr>
                        <td>関係:</td> <!-- 관계 / 関係 -->
                        <td>${hrCard.kankei}</td>
                    </tr>
                    <tr>
                        <td>名前:</td> <!-- 이름 / 名前 -->
                        <td>${hrCard.namae}</td>
                    </tr>
                    <tr>
                        <td>住民番号:</td> <!-- 주민 번호 / 住民番号 -->
                        <td>${hrCard.zyuumin_touroku_bangou}</td>
                    </tr>
                    <tr>
                        <td>同居有無:</td> <!-- 동거 유무 / 同居有無 -->
                        <td>${hrCard.doukyo_umu}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

<!-- hrCardList04 -->
<c:choose>
    <c:when test="${empty hrCardList04}">
        <p></p> <!-- 빈 문단 / 空の段落 -->
    </c:when>
    <c:otherwise>
        <table class="record-card">
            <tr class="section-title">
                <th colspan="2">保険種類</th> <!-- 보험 종류 / 保険種類 -->
            </tr>
            <c:forEach var="hrCard" items="${hrCardList04}">
                <c:if test="${hrCard.shain_ID == 1}">
                    <tr>
                        <td>国民年金:</td> <!-- 국민연금 / 国民年金 -->
                        <td>${hrCard.hoken_shurui}</td>
                    </tr>
                    <tr>
                        <td>記号番号:</td> <!-- 기호 번호 / 記号番号 -->
                        <td>${hrCard.touroku_bangou}</td>
                    </tr>
                    <tr>
                        <td>取得日:</td> <!-- 취득일 / 取得日 -->
                        <td>${hrCard.shutoku_bi}</td>
                    </tr>
                    <tr>
                        <td>喪失日:</td> <!-- 상실일 / 喪失日 -->
                        <td>${hrCard.sousitsu_bi}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

<!-- hrCardList05 -->
<c:choose>
    <c:when test="${empty hrCardList05}">
        <p> </p> <!-- 빈 문단 / 空の段落 -->
    </c:when>
    <c:otherwise>
        <table class="record-card">
            <tr class="section-title">
                <th colspan="2">学歴</th> <!-- 학력 / 学歴 -->
            </tr>
            <c:forEach var="hrCard" items="${hrCardList05}">
                <c:if test="${hrCard.shain_ID == 1}">
                    <tr>
                        <td>学校名:</td> <!-- 학교명 / 学校名 -->
                        <td>${hrCard.gakkou_mei}</td>
                    </tr>
                    <tr>
                        <td>入学年月:</td> <!-- 입학 연월 / 入学年月 -->
                        <td>${hrCard.nyuugaku_bi}</td>
                    </tr>
                    <tr>
                        <td>卒業年月:</td> <!-- 졸업 연월 / 卒業年月 -->
                        <td>${hrCard.sotsugyou_bi}</td>
                    </tr>
                    <tr>
                        <td>専攻:</td> <!-- 전공 / 専攻 -->
                        <td>${hrCard.senkou}</td>
                    </tr>
                    <tr>
                        <td>履修:</td> <!-- 이수 / 履修 -->
                        <td>${hrCard.sotsugyou_umu}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

<!-- hrCardList06 -->
<c:choose>
    <c:when test="${empty hrCardList06}">
        <p> </p> <!-- 빈 문단 / 空の段落 -->
    </c:when>
    <c:otherwise>
        <table class="record-card">
            <tr class="section-title">
                <th colspan="2">兵役</th> <!-- 병역 / 兵役 -->
            </tr>
            <c:forEach var="hrCard" items="${hrCardList06}">
                <c:if test="${hrCard.shain_ID == 1}">
                    <tr>
                        <td>兵役区分:</td> <!-- 병역 구분 / 兵役区分 -->
                        <td>${hrCard.heieki_kubun}</td>
                    </tr>
                    <tr>
                        <td>軍別:</td> <!-- 군별 / 軍別 -->
                        <td>${hrCard.gun_betsu}</td>
                    </tr>
                    <tr>
                        <td>服務期間:</td> <!-- 복무 기간 / 服務期間 -->
                        <td>${hrCard.hukumu_kaishi_bi}~${hrCard.hukumu_shuuryou_bi}</td>
                    </tr>
                    <tr>
                        <td>未了事由:</td> <!-- 미료 사유 / 未了事由 -->
                        <td>${hrCard.miryou_ziyuu}</td>
                    </tr>
                    <tr>
                        <td>最終階級:</td> <!-- 최종 계급 / 最終階級 -->
                        <td>${hrCard.saishuu_kaikyuu}</td>
                    </tr>
                    <tr>
                        <td>兵科:</td> <!-- 병과 / 兵科 -->
                        <td>${hrCard.heika}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>


<!-- hrCardList07 자격/면허 資格免許-->
<c:choose>
    <c:when test="${empty hrCardList07}">
        <p> </p> <!-- 빈 문단 / 空の段落 -->
    </c:when>
    <c:otherwise>
        <table class="record-card">
            <tr class="section-title">
                <th colspan="2">経歴</th> <!-- 경력 / 経歴 -->
            </tr>
            <c:forEach var="hrCard" items="${hrCardList07}">
                <c:if test="${hrCard.shain_ID == 1}">
                    <tr>
                        <td>会社名:</td> <!-- 회사명 / 会社名 -->
                        <td>${hrCard.kaisha_mei}</td>
                    </tr>
                    <tr>
                        <td>入社日:</td> <!-- 입사일 / 入社日 -->
                        <td>${hrCard.nyuusha_bi}</td>
                    </tr>
                    <tr>
                        <td>退職日:</td> <!-- 퇴직일 / 退職日 -->
                        <td>${hrCard.taishoku_bi}</td>
                    </tr>
                    <tr>
                        <td>最終役職:</td> <!-- 최종 직책 / 最終役職 -->
                        <td>${hrCard.saishuu_yakushoku}</td>
                    </tr>
                    <tr>
                        <td>担当職務:</td> <!-- 담당 직무 / 担当職務 -->
                        <td>${hrCard.tantou_shokumu}</td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

<!-- hrCardList08 어학능력 語学能力-->
<c:choose>
    <c:when test="${empty hrCardList08}">
        <p></p> <!-- 빈 문단 / 空の段落 -->
    </c:when>
    <c:otherwise>
        <table class="record-card">
            <tr class="section-title">
                <th colspan="2">語学能力</th> <!-- 어학 능력 / 語学能力 -->
            </tr>
            <c:forEach var="hrCard" items="${hrCardList08}">
                <c:if test="${hrCard.shain_ID == 1}">
                    <tr>
                        <td>社員ID:</td> <!-- 직원 ID / 社員ID -->
                        <td>${hrCard.shain_ID}</td>
                    </tr>
                    <tr>
                        <td>外国語名:</td> <!-- 외국어명 / 外国語名 -->
                        <td>${hrCard.gaikokugo_mei}</td>
                    </tr>
                    <tr>
                        <td>試験:</td> <!-- 시험 / 試験 -->
                        <td>${hrCard.shiken_mei}</td>
                    </tr>
                    <tr>
                        <td>取得日:</td> <!-- 취득일 / 取得日 -->
                        <td>${hrCard.shutoku_bi}</td>
                    </tr>
                    <tr>
                        <td>読解:</td> <!-- 독해 / 読解 -->
                        <td>${hrCard.dokkai}</td>
                    </tr>
                    <tr>
                        <td>作文:</td> <!-- 작문 / 作文 -->
                        <td>${hrCard.sakubun}</td>
                    </tr>
                    <tr>
                        <td>会話:</td> <!-- 회화 / 会話 -->
                        <td>${hrCard.kaiwa}</td>
                    </tr>
                    
                </c:if>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

<!-- hrCardList09 교육사항 教育事項 -->
<c:choose>
    <c:when test="${empty hrCardList09}">
        <p></p> <!-- 빈 문단 / 空の段落 -->
    </c:when>
    <c:otherwise>
        <table class="record-card">
            <tr>
                <th colspan="2" class="section-title">教育事項</th> <!-- 교육 사항 / 教育事項 -->
            </tr>
            <c:forEach var="hrCard" items="${hrCardList09}">
                <c:if test="${hrCard.shain_ID == 1}">
                    <tr>
                        <td>教育区分:</td> <!-- 교육 구분 / 教育区分 -->
                        <td>${hrCard.kyouiku_shurui}</td>
                    </tr>
                    <tr>
                        <td>教育名:</td> <!-- 교육명 / 教育名 -->
                        <td>${hrCard.kyouiku_mei}</td>
                    </tr>
                    <tr>
                        <td>教育機関（開始日）:</td> <!-- 교육 기관(시작일) / 教育機関（開始日） -->
                        <td>${hrCard.kaishi_bi}</td>
                    </tr>
                    <tr>
                        <td>教育機関（終了日）:</td> <!-- 교육 기관(종료일) / 教育機関（終了日） -->
                        <td>${hrCard.shuuryou_bi}</td>
                    </tr>
                    <tr>
                        <td>教育機関:</td> <!-- 교육 기관 / 教育機関 -->
                        <td>${hrCard.kyouiku_kikan_mei}</td>
                    </tr>
                    <tr>
                        <td>教育費:</td> <!-- 교육비 / 教育費 -->
                        <td>${hrCard.kyouiku_hi}</td>
                    </tr>
                    <tr>
                        <td>還付教育費:</td> <!-- 환급 교육비 / 還付教育費 -->
                        <td>${hrCard.kanpu_kyouiku_hi}</td>
                    </tr>
                    <tr><td colspan="2"><hr/></td></tr> <!-- 구분선 / 区切り線 -->
                </c:if>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

<!-- hrCardList10 상벌사항 賞罰事項 -->
<c:choose>
    <c:when test="${empty hrCardList10}">
        <p></p> <!-- 빈 문단 / 空の段落 -->
    </c:when>
    <c:otherwise>
        <table class="record-card">
            <tr>
                <th colspan="2" class="section-title">賞罰事項</th> <!-- 상벌 사항 / 賞罰事項 -->
            </tr>
            <c:forEach var="hrCard" items="${hrCardList10}">
                <c:if test="${hrCard.shain_ID == 1}">
                    <tr>
                        <td>区分:</td> <!-- 구분 / 区分 -->
                        <td>${hrCard.shoubatsu_kubun}</td>
                    </tr>
                    <tr>
                        <td>賞罰名:</td> <!-- 상벌명 / 賞罰名 -->
                        <td>${hrCard.shoubatsu_mei}</td>
                    </tr>
                    <tr>
                        <td>賞罰権者:</td> <!-- 상벌 권자 / 賞罰権者 -->
                        <td>${hrCard.kantoku_kikan}</td>
                    </tr>
                    <tr>
                        <td>賞罰日:</td> <!-- 상벌일 / 賞罰日 -->
                        <td>${hrCard.shoubatsu_bi}</td>
                    </tr>
                    <tr>
                        <td>賞罰内容:</td> <!-- 상벌 내용 / 賞罰内容 -->
                        <td>${hrCard.naiyou}</td>
                    </tr>
                    <tr>
                        <td>備考:</td> <!-- 비고 / 備考 -->
                        <td>${hrCard.bikou}</td>
                    </tr>
                    <tr><td colspan="2"><hr/></td></tr> <!-- 구분선 / 区切り線 -->
                </c:if>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>


<!-- hrCardList11 人事発令 -->
<c:choose>
    <c:when test="${empty hrCardList11}">
        <p></p>
    </c:when>
    <c:otherwise>
        <table class="record-card">
            <tr>
                <th colspan="2" class="section-title">人事発令</th>
            </tr>
            <c:forEach var="hrCard" items="${hrCardList11}">
                <c:if test="${hrCard.shain_ID == 1}">
                    <tr>
                        <td>発令区分:</td>
                        <td>${hrCard.hatsurei_kubun}</td>
                    </tr>
                    <tr>
                        <td>発令日:</td>
                        <td>${hrCard.hatsurei_bi}</td>
                    </tr>
                    <tr>
                        <td>部署:</td>
                        <td>${hrCard.bu}</td>
                    </tr>
                    <tr>
                        <td>役職:</td>
                        <td>${hrCard.yakushoku_mei}</td>
                    </tr>
                    <tr>
                        <td>役職及び担当業務:</td>
                        <td>${hrCard.shokumu_mei}</td>
                    </tr>
                    <tr>
                        <td>備考:</td>
                        <td>${hrCard.bikou}</td>
                    </tr>
                    <tr><td colspan="2"><hr/></td></tr>
                </c:if>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

<!-- hrCardList12 退職事項 -->
<c:choose>
    <c:when test="${empty hrCardList12}">
        <p></p>
    </c:when>
    <c:otherwise>
        <table class="record-card">
            <tr>
                <th colspan="2" class="section-title">退職事項</th>
            </tr>
            <c:forEach var="hrCard" items="${hrCardList12}">
                <c:if test="${hrCard.shain_ID == 1}">
                    <tr>
                        <td>退職区分:</td>
                        <td>${hrCard.taishoku_kubun}</td>
                    </tr>
                    <tr>
                        <td>退職日:</td>
                        <td>${hrCard.taishoku_bi}</td>
                    </tr>
                    <tr>
                        <td>退職事由:</td>
                        <td>${hrCard.taishoku_ziyuu}</td>
                    </tr>
                    <tr>
                        <td>退職金:</td>
                        <td>${hrCard.taishoku_kin}</td>
                    </tr>
                    <tr>
                        <td>退職後連絡先</td>
                        <td>${hrCard.taishoku_go_renrakusaki}</td>
                    </tr>
                    <tr><td colspan="2"><hr/></td></tr>
                </c:if>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

<!-- hrCardList13 신상 정보 -->
<c:choose>
    <c:when test="${empty hrCardList13}">
        <p></p>
    </c:when>
    <c:otherwise>
        <table class="record-card">
            <tr class="section-title">
                <th colspan="2">印章</th>
            </tr>
            <c:forEach var="hrCard" items="${hrCardList13}">
                <tr>
                    <td>사원ID:</td>
                    <td>${hrCard.shain_ID}</td>
                </tr>
                <tr>
                    <td>주소:</td>
                    <td>${hrCard.address}</td>
                </tr>
            </c:forEach>
        </table>
    </c:otherwise>
</c:choose>

    
    

<script>
    function openModal() {
        // モーダルを表示する
        document.getElementById("employeeModal").style.display = "block";
    }

    function closeModal() {
        // モーダルを非表示にする
        document.getElementById("employeeModal").style.display = "none";
    }

    // モーダルの外をクリックしたときにモーダルを閉じる機能
    window.onclick = function(event) {
        const modal = document.getElementById("employeeModal");
        if (event.target == modal) {
            // モーダルを非表示にする
            modal.style.display = "none";
        }
    }
</script>


</body>
</html>