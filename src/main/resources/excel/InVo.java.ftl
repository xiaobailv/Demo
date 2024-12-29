
public class ${txnName}InVo {

<#if voInfoList??>
    <#list voInfoList as voInfo>
    /**
     * ${voInfo.comment}
     */
    private ${voInfo.javaType} ${voInfo.javaName};
    </#list>
</#if>

<#if voInfoList??>
    <#list voInfoList as voInfo>
    /**
    * ${voInfo.comment}
    */
    public ${voInfo.javaType} get${voInfo.javaName?cap_first}() {
        return ${voInfo.javaName};
    }

    /**
    * ${voInfo.comment}
    */
    public void set${voInfo.javaName?cap_first}(${voInfo.javaType} ${voInfo.javaName}) {
        return ${voInfo.javaName};
    }
    </#list>
</#if>
}