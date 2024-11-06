<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>社員現況／管理</title>
    <style>
        /* 기본 스타일 基本スタイル */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        h3 {
            text-align: center;
            color: #333;
        }

        /* 상태 필터 버튼 스타일 状態フィルタボタンスタイル*/
        .button01 {
            background-color: #FF2266;
            color: white;
            padding: 8px 16px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            border-radius: 5px;
            margin: 5px;
        }
        
                /* 상태 필터 버튼 스타일 状態フィルタボタンスタイル*/
        .button02 {
            background-color: #0088FF;
            color: white;
            padding: 8px 16px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            border-radius: 5px;
            margin: 5px;
        }
        
                /* 상태 필터 버튼 스타일 状態フィルタボタンスタイル*/
        .button03 {
            background-color: #777777;
            color: white;
            padding: 8px 16px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            border-radius: 5px;
            margin: 5px;
        }
        
                        /* 상태 필터 버튼 스타일 状態フィルタボタンスタイル*/
        .button04 {
            background-color: #444444;
            color: white;
            padding: 8px 16px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            border-radius: 5px;
            margin: 5px;
        }

        /* 필터 버튼 섹션 스타일　フィルタボタンセッションスタイル */
        .filter-section {
            text-align: center;
            margin-bottom: 20px;
        }
        
        /* 검색창과 선택 박스 스타일 検索欄と洗濯ボックススタイル*/
        .search-section {
            display: flex;
            justify-content: space-between;
            padding: 20px;
        }

        /* 테이블 스타일 テーブルスタイル*/
        table {
            width: 600px%;
            border-collapse: collapse;
            margin: 20px 0;
        }

        table, th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }

        th {
            background-color: #9999FF;
            color: white;
        }

        /* 하단 버튼 스타일 下段ボタンスタイル*/
        .bottom-buttons {
            text-align: center;
            margin: 20px;
        }

        /* 모달 배경 스타일 モダル背景スタイル*/
        .modal03 { /* 모달 배경 / モーダル背景 */
            display: none; /* 초기에는 숨김 初期には隠す*/
            position: fixed;
            z-index: 1000;
            left: 0;
            top: 0;
            width: 100%;
            height: 100%;
            overflow: auto;
            background-color: rgba(0, 0, 0, 0.4); /* 반투명 검은색 배경 半透明黒い背景*/
        }

        /* 모달 창 스타일 */
        .modal-content { /* 모달 내용 / モーダル内容 */
            position: relative;
            background-color: #fff;
            margin: 10% auto; /* 화면 중앙에 위치 画面真ん中に位置*/
            padding: 20px;
            width: 50%;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        /* 닫기 버튼 스타일 閉めボタンスタイル*/
        .close { /* 닫기 버튼 / 閉じるボタン */
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
            cursor: pointer;
        }

        .close:hover,
        .close:focus {
            color: #000;
            text-decoration: none;
        }
    </style>
</head>
<body>

<form action="empman.do" method="post" id="employeeForm">
<!-- 사원 관리 타이틀 / 社員管理タイトル -->
<h3><label>社員現況／管理</label></h3>
<p class="description">全体社員の現況を見ることができるし、選択すると該当社員登録（情報）ページに移動します。</p>
<hr>

<!-- 상태 필터 버튼 섹션 / 状態フィルタボタンセクション -->
<div class="filter-section">
    <a href="/payzon1/empman.do?zyoutai=1" class="button01">在職者</a> <!-- 재직자 / 在職者 -->
    <a href="/payzon1/empman.do?koyou_keitai=1" class="button02">正規職</a> <!-- 정규직 / 正規職 -->
    <a href="/payzon1/empman.do?koyou_keitai=2" class="button02">契約職</a> <!-- 계약직 / 契約職 -->
    <a href="/payzon1/empman.do?koyou_keitai=3" class="button02">臨時職</a> <!-- 임시직 / 臨時職 -->
    <a href="/payzon1/empman.do?koyou_keitai=4" class="button02">派遣職</a> <!-- 파견직 / 派遣職 -->
    <a href="/payzon1/empman.do?koyou_keitai=5" class="button02">委嘱職</a> <!-- 위촉직 / 委嘱職 -->
    <a href="/payzon1/empman.do?koyou_keitai=6" class="button02">日雇い職</a> <!-- 일용직 / 日雇い職 -->
    <a href="/payzon1/empman.do?zyoutai=2" class="button03">退職者</a> <!-- 퇴직자 / 退職者 -->
    <a href="/payzon1/empman.do?zyoutai=3" class="button04">全体</a> <!-- 전체 / 全体 -->
</div>

<!-- 검색 및 설정 섹션 / 検索と設定セクション -->
<div class="search-section">
    <!-- 검색 섹션 / 検索セクション -->
    <div>
        <select name="selDprtCode">
            <option value>全体</option> <!-- 전체 / 全体 -->
            <option value="namae">名前</option> <!-- 이름 / 名前 -->
            <option value="bu">部署</option> <!-- 부서 / 部署 -->
            <option value="yakushoku">役職</option> <!-- 직책 / 役職 -->
            <option value="shain_ID">社員番号</option> <!-- 사원 번호 / 社員番号 -->
        </select>
        <input type="search" name="title" placeholder="検索語入力"> <!-- 검색어 입력 / 検索語入力 -->
        <button onclick="searchEmployee()">検索</button> <!-- 검색 / 検索 -->
    </div>

    <!-- 고용 형태 및 상태 선택 / 雇用形態と状態選択 -->
    <div>
        <select name="selKoyou_KeitaiCode">
            <option value>雇用形態別</option> <!-- 고용 형태별 / 雇用形態別 -->
            <option value="001">正規職</option> <!-- 정규직 / 正規職 -->
            <option value="002">契約職</option> <!-- 계약직 / 契約職 -->
            <option value="003">臨時職</option> <!-- 임시직 / 臨時職 -->
            <option value="004">派遣職</option> <!-- 파견직 / 派遣職 -->
            <option value="005">委嘱職</option> <!-- 위촉직 / 委嘱職 -->
            <option value="006">日雇い職</option> <!-- 일용직 / 日雇い職 -->
        </select>
        
        <select name="selZyoutaiCode">
            <option value>状態別</option> <!-- 상태별 / 状態別 -->
            <option value="001">在職</option> <!-- 재직 / 在職 -->
            <option value="002">退職</option> <!-- 퇴직 / 退職 -->
        </select>
        
        <select name="selListCode">
            <option value>リスト数</option> <!-- 리스트 수 / リスト数 -->
            <option value="001">10個づつ見る</option> <!-- 10개씩 보기 / 10個ずつ見る -->
            <option value="002">30個づつ見る</option> <!-- 30개씩 보기 / 30個ずつ見る -->
            <option value="003">50個づつ見る</option> <!-- 50개씩 보기 / 50個ずつ見る -->
            <option value="004">100個づつ見る</option> <!-- 100개씩 보기 / 100個ずつ見る -->
        </select>
    </div>

<!-- 정렬 및 표시 설정 버튼 / 整列および表示設定ボタン -->
<div>
    <button onclick="openSortingModal()">整列基準設定</button> <!-- 정렬 기준 설정 / 整列基準設定 -->
    <button onclick="openDisplaySettings()">表示項目設定</button> <!-- 표시 항목 설정 / 表示項目設定 -->
</div>
</div>

<!-- 사원 목록 테이블 / 社員一覧テーブル -->
<table>
    <thead>
        <tr>
            <th><input type="checkbox" onclick="toggleAll(this)"></th> <!-- 전체 선택 체크박스 / 全選択チェックボックス -->
            <th>区分</th> <!-- 구분 / 区分 -->
            <th>入社日</th> <!-- 입사일 / 入社日 -->
            <th>社員番号</th> <!-- 사원 번호 / 社員番号 -->
            <th>名前(日本語)</th> <!-- 이름 (일본어) / 名前(日本語) -->
            <th>名前(英語)</th> <!-- 이름 (영어) / 名前(英語) -->
            <th>部署</th> <!-- 부서 / 部署 -->
            <th>役職</th> <!-- 직책 / 役職 -->
            <th>住民番号</th> <!-- 주민 번호 / 住民番号 -->
            <th>内／外国人</th> <!-- 내/외국인 / 内／外国人 -->
            <th>住所</th> <!-- 주소 / 住所 -->
            <th>電話番号</th> <!-- 전화 번호 / 電話番号 -->
            <th>携帯電話</th> <!-- 휴대전화 / 携帯電話 -->
            <th>E-Mail</th> <!-- 이메일 / E-Mail -->
            <th>SNS</th> <!-- SNS / SNS -->
            <th>退職日</th> <!-- 퇴직일 / 退職日 -->
            <th>状態</th> <!-- 상태 / 状態 -->
            <th>銀行口座</th> <!-- 은행 계좌 / 銀行口座 -->
        </tr>
    </thead>
    <tbody>
        <c:if test="${not empty employeeList01}">
            <c:forEach var="employee" items="${employeeList01}">
            <input type="hidden" name="action" value="delete"> <!-- action 값 추가 / action値追加 -->
                <tr>	
                    <td><input type="checkbox" name="selectedEmployees" value="${employee.shain_ID}"></td> <!-- 선택된 직원 체크박스 / 選択された社員チェックボックス -->
                    <td>${employee.koyou_keitai}</td> <!-- 고용 형태 / 雇用形態 -->
                    <td>${employee.nyuusha_bi}</td> <!-- 입사일 / 入社日 -->
                    <td>${employee.shain_ID}</td> <!-- 사원 번호 / 社員番号 -->
                    <td>${employee.shain_namae}</td> <!-- 일본어 이름 / 日本語の名前 -->
                    <td>${employee.shain_eigo_namae}</td> <!-- 영어 이름 / 英語の名前 -->
                    <td>${employee.bu}</td> <!-- 부서 / 部署 -->
                    <td>${employee.yakushoku}</td> <!-- 직책 / 役職 -->
                    <td>${employee.zyuumin_bangou}</td> <!-- 주민 번호 / 住民番号 -->
                    <td>${employee.nai_gaikokuzin}</td> <!-- 내/외국인 여부 / 内／外国人の有無 -->
                    <td>${employee.zyuusho}</td> <!-- 주소 / 住所 -->
                    <td>${employee.denwa_bangou}</td> <!-- 전화 번호 / 電話番号 -->
                    <td>${employee.keitai_bangou}</td> <!-- 휴대전화 번호 / 携帯電話番号 -->
                    <td>${employee.meiru_adoresu}</td> <!-- 이메일 주소 / メールアドレス -->
                    <td>${employee.sns}</td> <!-- SNS / SNS -->
                    <td>${employee.taisha_bi}</td> <!-- 퇴직일 / 退職日 -->
                    <td>
                    <c:choose>
                        <c:when test="${not empty employeeList03}">
                            <c:forEach var="status" items="${employeeList03}">
                                <c:if test="${status.shain_ID == employee.shain_ID}">
                                    ${status.zyoutai} <!-- shain_ID에 해당하는 상태 출력 / shain_IDに該当する状態出力-->
                                </c:if>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                             <!-- 상태 정보가 없을 때 공란 / 状態情報が無い時空欄-->
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <c:choose>
                        <c:when test="${not empty employeeList02}">
                            <c:forEach var="account" items="${employeeList02}">
                                <c:if test="${account.shain_ID == employee.shain_ID}">
                                    [${account.ginkou_mei}] ${account.kouza_bangou} <!-- shain_ID에 해당하는 은행 계좌 출력 / shain_IDに該当する銀行口座出力-->
                                </c:if>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                             <!-- 계좌 정보가 없을 때 공란 / 口座情報が無い時空欄 -->
                        </c:otherwise>
                    </c:choose>
					</td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>

<!-- 하단 버튼 영역 / 下段ボタンエリア -->

<span class="filter-section">
    <a href="/payzon1/empman.do?zyoutai=1" class="button">新規社員登録</a> <!-- 신규 사원 등록 / 新規社員登録 -->
</span>

<button type="button" class="button" onclick="openModal()">新規社員一括登録</button> <!-- 신규 사원 일괄 등록 / 新規社員一括登録 -->

<!-- 모달 창 구조 / モーダルウィンドウの構造 -->
<div id="modal03" class="modal03">
    <div class="modal-content">
        <span class="close" onclick="closeModal()">&times;</span> <!-- 닫기 버튼 / 閉じるボタン -->
        <h2>新規社員一括登録</h2> <!-- 신규 사원 일괄 등록 제목 / 新規社員一括登録タイトル -->
        <p>アップロードフォームをダウンロードして社員情報を入力したファイルをアップロードしてください。</p> <!-- 업로드 양식을 다운로드하고 사원 정보를 입력한 파일을 업로드하세요. / アップロードフォームをダウンロードして社員情報を入力したファイルをアップロードしてください。 -->
        
        <button type="button" onclick="">社員一括登録</button> <!-- 사원 일괄 등록 / 社員一括登録 -->
        <!-- 정렬 옵션을 위한 콘텐츠 / 整列オプション用のコンテンツ -->
    </div>
</div>

<span class="bottom-buttons">
    <button type="button" class="button" onclick="submitDelete()">洗濯削除</button> <!-- 선택 삭제 / 選択削除 -->
</span>

<span class="filter-section">
	<button type="button" class="button" onclick="submitExel">エクセルダウンロード</button> <!-- 엑셀 다운로드 / エクセルダウンロード -->
</span>
</form>



<!-- JavaScript 기능들 / JavaScript機能 -->

<script>
    // 전체 선택 / 해제 함수 / 全体選択/解除関数
    function toggleAll(source) {
        const checkboxes = document.querySelectorAll('input[name="selectedEmployees"]');
        checkboxes.forEach(checkbox => checkbox.checked = source.checked);
    }

    // 검색 버튼 클릭 시 동작 (기능 구현) / 検索ボタンクリック時の動作（機能実装）
    function searchEmployee() {
        // 실제 검색 구현 로직은 서버와 연동 필요 / 実際の検索実装ロジックはサーバーと連携する必要があります
        alert("検索機能はまだ具現できてません。"); // 검색 기능은 아직 구현되지 않았습니다.
    }

    // 정렬기준 설정 모달 열기 / 整列基準設定モダルを開く
    function openSortingModal() {
        alert("整列基準設定モダルを開く機能です。"); // 정렬 기준 설정 모달을 여는 기능입니다.
        // 정렬기준 설정 관련 UI와 기능을 모달로 구현 / 整列基準設定関連のUIと機能をモダルで実装
    }

    // 정렬기준 설정 모달 닫기도 만들어야함 / 整列基準設定モダルを閉じる機能も作る必要があります
    function closeSortingModal(){
        // 여기에 모달 닫기 로직 추가 / ここにモーダルを閉じるロジックを追加
    }

    // 표시 항목 설정 모달 열기 / 表示項目設定モダルを開く
    function openDisplaySettings() {
        alert("表示項目設定モダルを開く機能です。"); // 표시 항목 설정 모달을 여는 기능입니다.
        // 표시 항목 설정 관련 UI와 기능을 모달로 구현 / 表示項目設定関連のUIと機能をモダルで実装
    }

    // 표시항복 설정 모달 닫기도 만들어야함 / 表示項目設定モダルを閉じる機能も作る必要があります
    function closeDisplaySetting(){
        // 여기에 모달 닫기 로직 추가 / ここにモーダルを閉じるロジックを追加
    }

    // 모달 열기 함수 / モーダルを開く関数
    function openModal() {
        document.getElementById("modal03").style.display = "block"; // 모달 표시
    }

    // 모달 닫기 함수 / モーダルを閉じる関数
    function closeModal() {
        document.getElementById("modal03").style.display = "none"; // 모달 숨김
    }

    // 모달 외부 클릭 시 닫기 / モーダルの外側をクリックすると閉じる
    window.onclick = function(event) {
        const modal = document.getElementById("modal03");
        if (event.target == modal) {
            modal.style.display = "none"; // 모달 숨김
        }
    }

    // 삭제 버튼 클릭 시 체크된 항목 확인 및 삭제 요청 / 削除ボタンをクリックすると選択された項目を確認して削除要求
    function submitDelete() {
        const selectedEmployees = document.querySelectorAll('input[name="selectedEmployees"]:checked');
        
        if (selectedEmployees.length === 0) {
            // 체크된 항목이 없을 때 경고 메시지 / チェックされた項目がないとき警告メッセージ
            alert("選択された社員がいません。"); // 선택된 사원이 없습니다.
            return;
        }

        // 체크된 항목이 있을 때 삭제 확인 메시지 / チェックされた項目がある場合削除確認メッセージ
        const confirmMessage = "選択した社員の勤怠及び給与と関連された全ての情報も一緒に削除されます。\n\n" +
                               "削除された社員情報及び関連する全ての情報は復旧できません。\n\n" +
                               "削除しますか。"; // 삭제 시 관련된 모든 정보도 함께 삭제됩니다. 삭제된 정보는 복구할 수 없습니다. 삭제하시겠습니까?
        
        if (confirm(confirmMessage)) {
            document.getElementById("employeeForm").submit();
            alert("選択した社員の情報が削除できました。"); // 선택된 사원의 정보가 삭제되었습니다.
        }
    }
</script>

</body>
</html>