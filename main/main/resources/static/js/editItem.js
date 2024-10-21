$(document).ready(function() {
    // URL에서 ID 값 가져오기
    const urlParams = new URLSearchParams(window.location.search);
    const itemId = urlParams.get('id');

    // 아이템 정보 불러오기 (예시)
    $.ajax({
        url: `/api/item/${itemId}`,
        type: 'GET',
        success: function(item) {
            $('#itemId').val(item.id);
            $('#editItemName').val(item.item);
            $('#editPrice').val(item.price);
            $('#editDetail').val(item.detail);
            $('#editSelectBar').val(item.category);
        },
        error: function() {
            alert('상품 정보를 불러오는 데 실패했습니다.');
        }
    });
});
