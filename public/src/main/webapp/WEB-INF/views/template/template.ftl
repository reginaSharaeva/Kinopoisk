<#macro mainTemplate title="Online Movies">
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${title}</title>
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport"
          content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link href="/resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" href="/resources/i/favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="/resources/css/style.css">
    <link type="text/css" rel="stylesheet" href="/resources/css/cbb092d6554938a9549cb716ffcb1f94.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/babel-core/5.8.24/browser.min.js"></script>
    <script src="/resources/js/jquery-3.1.1.min.js"></script>
    <script src="/resources/js/jquery-ui.min.js"></script>
    <script src="/resources/js/react/react.js"></script>
    <script type="text/babel" src="/resources/js/react/Search.js"></script>
    <script src="/resources/js/react/react-dom.min.js"></script>
    <script src="/resources/js/main.js"></script>
</head>
<body>
<div class="page">
    <#include "components/header.ftl" />
    <@m_body />
    <#include "components/footer.ftl" />
</div>
<a href="#" id="ui-to-top" class="ui-to-top fa fa-angle-up">
    <div style="font-size: 50px;" class="material-icons"></div>
</a>
<!-- jQuery -->
<#--<script src="http://code.jquery.com/jquery-latest.js"></script>-->
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="/resources/css/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<#--<script src="/resources/js/core.min.js"></script>-->
<script src="/resources/js/script.js"></script>
<script>
    $(function () {
        $(document).ready(function(e){
            $('.search-panel .dropdown-menu').find('a').click(function(e) {
                e.preventDefault();
                var param = $(this).attr("href").replace("#","");
                var concept = $(this).text();
                $('.search-panel span#search_concept').text(concept);
                $('.input-group #search_param').val(param);
            });
        });
        $('.button-checkbox').each(function () {

            // Settings
            var $widget = $(this),
                    $button = $widget.find('button'),
                    $checkbox = $widget.find('input:checkbox'),
                    color = $button.data('color'),
                    settings = {
                        on: {
                            icon: 'glyphicon glyphicon-check'
                        },
                        off: {
                            icon: 'glyphicon glyphicon-unchecked'
                        }
                    };

            // Event Handlers
            $button.on('click', function () {
                $checkbox.prop('checked', !$checkbox.is(':checked'));
                $checkbox.triggerHandler('change');
                updateDisplay();
            });
            $checkbox.on('change', function () {
                updateDisplay();
            });

            // Actions
            function updateDisplay() {
                var isChecked = $checkbox.is(':checked');

                // Set the button's state
                $button.data('state', (isChecked) ? "on" : "off");

                // Set the button's icon
                $button.find('.state-icon')
                        .removeClass()
                        .addClass('state-icon ' + settings[$button.data('state')].icon);

                // Update the button's color
                if (isChecked) {
                    $button
                            .removeClass('btn-default')
                            .addClass('btn-' + color + ' active');
                }
                else {
                    $button
                            .removeClass('btn-' + color + ' active')
                            .addClass('btn-default');
                }
            }

            // Initialization
            function init() {

                updateDisplay();

                // Inject the icon if applicable
                if ($button.find('.state-icon').length == 0) {
                    $button.prepend('<i class="state-icon ' + settings[$button.data('state')].icon + '"></i>');
                }
            }
            init();
        });
        function toggleChevron(e) {
            $(e.target)
                    .prev('.panel-heading')
                    .find("i.indicator")
                    .toggleClass('fa-caret-down fa-caret-right');
        }
        $('#accordion').on('hidden.bs.collapse', toggleChevron);
        $('#accordion').on('shown.bs.collapse', toggleChevron);
    });

</script>
</body>
</html>
</#macro>