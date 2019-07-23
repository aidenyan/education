(function ($, window) {

    var getValue = function (attrValue, data) {
        if (!Utils.isNotNull(data)) {
            return null;
        }
        if (Utils.isBlank(attrValue)) {
            return null;
        }
        var indexStart = attrValue.indexOf(".");
        if (indexStart < 0) {
            return data[attrValue];
        } else {
            return getValue(attrValue.substring(indexStart + 1), data[attrValue.substring(0, indexStart)])
        }
    }
    var writeValue = function (attrValue, data,value) {
        if(value==""){
            return;
        }
        var indexStart = attrValue.indexOf(".");
        if (indexStart < 0) {
            data[attrValue] = value;
        } else {
            data[attrValue] = {};
            writeValue(attrValue.substring(indexStart + 1), data[attrValue], value);
        }
    }


    var textInput = function (documentObj, data) {
        var attrValue = $(documentObj).attr("temp-value");
        var value = getValue(attrValue, data);
        if (value == null) {
            $(documentObj).val("");
        } else {
            $(documentObj).val(value);
        }
    }


    var checkBox = function (documentObj, data) {
        var attrValue = documentObj.attr("temp-value");
        var value = getValue(attrValue, data);
        if (value == null) {
            $(documentObj).remove("checked");
        } else {
            $(documentObj).remove("checked");
            if (Utils.isArray(value)) {
                if (Utils.isContain(value, $(documentObj).val())) {
                    $(documentObj).attr("checked", "checked");
                }
            } else if (value+"" == $(documentObj).val()) {
                $(documentObj).attr("checked", "checked");
            }
        }
    }
    var selectDeal = function (documentObj, data) {
        var attrValue = $(documentObj).attr("temp-value");
        var value = getValue(attrValue, data);
        $(documentObj).find("option").each(function () {
            $(this).remove("selected")
            if (value != null && value == $(this).val()) {
                $(this).attr("selected", "selected")
            }
        })

    }
    var formRead = function (formId, data) {
        $("#" + formId).find("input").each(function () {
            if (Utils.isContain(["email", "text", "password", "hidden"], $(this).attr("type"))) {
                textInput($(this), data);
            } else if (Utils.isContain(["checkbox", "radio"], $(this).attr("type"))) {
                checkBox($(this), data);
            }
        })
        $("#" + formId).find("select").each(function () {
            selectDeal($(this), data);
        });
        $("#" + formId).find("textArea").each(function () {
            textInput($(this), data);
        })
    }
    var textInputWrite = function (documentObj, data) {
        var attrValue = $(documentObj).attr("temp-value");
        writeValue(attrValue, data, $(documentObj).val());
    }
    var checkBoxWrite = function (documentObj, data) {
        var attrValue = $(documentObj).attr("temp-value");
        if ($(documentObj).attr("checked") == "checked") {
            if ($(documentObj).attr("type") == "radio") {
                writeValue(attrValue, data, $(documentObj).val());
            } else if($(documentObj).attr("signle")=="signle"){
                writeValue(attrValue, data, $(documentObj).val());
            }else{
                var value = getValue(attrValue, data);
                if(value==null){
                    value=new Array();
                }
                value.push($(documentObj).val())
                writeValue(attrValue, data,value);
            }
        }

    }
    var selectWrite = function (documentObj, data) {
        var attrValue = $(documentObj).attr("temp-value");
        var value = writeValue(attrValue, data, $(documentObj).val());


    }
    var formWrite = function (formId) {
        var data = {}
        $("#" + formId).find("input").each(function () {
            if (Utils.isContain(["email", "text", "password", "hidden"], $(this).attr("type"))) {
                textInputWrite($(this), data);
            } else if (Utils.isContain(["checkbox", "radio"], $(this).attr("type"))) {
                checkBoxWrite($(this), data);
            }
        })
        $("#" + formId).find("select").each(function () {
            selectWrite($(this), data);
        })
        $("#" + formId).find("textArea").each(function () {
            textInputWrite($(this), data);
        })
        return data;
    }


    var isRead = function (formId) {
        $("#" + formId).find("input").each(function () {
            $(this).attr("disabled", "disabled")
        })
        $("#" + formId).find("select").each(function () {
            $(this).attr("disabled", "disabled")
        })
        $("#" + formId).find("textArea").each(function () {
            $(this).attr("disabled", "disabled")
        })
    }
    window.isRead = isRead
    window.formRead = formRead;
    window.formWrite = formWrite;
})(jQuery, window);