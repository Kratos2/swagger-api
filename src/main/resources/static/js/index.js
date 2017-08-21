var apiList = new Vue({
    el: '#api-list',
    data: {
        apis: []
    },
    methods: {
        openApi: function (search) {
            this.setCookie('api', JSON.stringify({
                url: '/api/basePath?host=',
                param: search
            }), 24 * 7);
            // location.href = 'swagger/index.html?url=' + encodeURIComponent(search);
            location.href = 'swagger/index.html';
        },
        setCookie: function (name, value, hours) {
            const d = new Date();
            const offset = 8;
            const utc = d.getTime() + (d.getTimezoneOffset() * 60000);
            const nd = utc + (3600000 * offset);
            const exp = new Date(nd);
            exp.setTime(exp.getTime() + hours * 60 * 60 * 1000);
            document.cookie = name + '=' + escape(value) + ';path=/;expires=' + exp.toGMTString();
        }
    },
    mounted: function () {
        console.log("done");
        $.ajax({
            url: 'api/',
            datatype: 'json',
            type: "get",
            contentType: "application/json",
            success: function (data) {
                $.each(data, function(i, v){
                    apiList.apis.push(v);

                });
            },
            error: function () {
                alert("An error during data retrieving. Please, try again later");
            }
        });
    }
});
