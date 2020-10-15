package com.zzp.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * @Description fastJson扩展工具类
 * @Author karyzeng
 * @since 2020.10.14
 **/
public class FastJsonUtils {

    public static String filterBlankValue(String jsonStr) {
        if (StringUtils.isBlank(jsonStr)) {
            return null;
        }
        JSONObject result = new JSONObject();
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        for (Map.Entry entry : jsonObject.entrySet()) {
            if (StringUtils.isNotBlank(entry.getValue().toString())) {
                result.put(entry.getKey().toString(), entry.getValue());
            }
        }
        return result.toJSONString();
    }

    public static void main(String[] args) {
        String jsonStr = "{\"companyCode\":\"4401482019\",\"contractNoPrefix\":\"\",\"createTime\":1602655697000,\"createrId\":\"9900\",\"currencyPre\":\"\",\"currencyPreValue\":\"\",\"currencySymbol\":\"\",\"customsDeclarationUnit\":\"\",\"customsDeclarationUnitValue\":\"\",\"departurePort\":\"\",\"departurePortName\":\"\",\"desCountry\":\"ATA\",\"desCountryValue\":\"南极洲\",\"destPlaces\":\"\",\"destPlacesName\":\"\",\"destination\":\"\",\"destinationValue\":\"\",\"exemptionNature\":\"\",\"exemptionNatureValue\":\"\",\"exemptionType\":\"\",\"exemptionTypePre\":\"\",\"exemptionTypePreValue\":\"\",\"exemptionTypeValue\":\"\",\"extCurrency\":\"\",\"extCurrencyCode\":\"\",\"extCurrencyName\":\"\",\"extType\":\"\",\"extTypeName\":\"\",\"extValue\":\"\",\"freCurrency\":\"\",\"freCurrencyName\":\"\",\"freType\":\"\",\"freTypeName\":\"\",\"freValue\":\"\",\"goodsAttr\":\"19\",\"goodsAttrName\":\"正常\",\"goodsPlace\":\"\",\"headSetingName\":\"zzp进口报关单模板101401\",\"id\":\"402848a37524cef7017525b93b62007c\",\"insCurrency\":\"\",\"insCurrencyName\":\"\",\"insType\":\"\",\"insTypeName\":\"\",\"insValue\":\"\",\"inspCheckOrgCode\":\"\",\"inspCheckOrgName\":\"\",\"inspPortOrgCode\":\"\",\"inspPortOrgName\":\"\",\"inspPurpOrgCode\":\"\",\"inspPurpOrgName\":\"\",\"inspVsaOrgCode\":\"\",\"inspVsaOrgName\":\"\",\"inspectionoriginCode\":\"\",\"inspectionoriginName\":\"\",\"isImport\":\"I\",\"loadPlace\":\"\",\"loadPlaceEnName\":\"\",\"loadPlaceName\":\"\",\"loadingPort\":\"\",\"loadingPortValue\":\"\",\"loadingPortValueEn\":\"\",\"note\":\"\",\"origPlaceCode\":\"\",\"origPlaceName\":\"\",\"originCountry\":\"\",\"originCountryValue\":\"\",\"packageType\":\"\",\"packageTypeValue\":\"\",\"paymentMethod\":\"\",\"paymentMethodValue\":\"\",\"port\":\"\",\"portValue\":\"\",\"sailed\":\"\",\"sailedValue\":\"\",\"sailedValueEn\":\"\",\"shippingType\":\"2\",\"shippingTypeValue\":\"水路运输\",\"submitCustoms\":\"0109\",\"submitCustomsValue\":\"机场旅检\",\"supplierCode\":\"\",\"supplierName\":\"\",\"tradeMode\":\"\",\"tradeModeValue\":\"\",\"tradingCountryArea\":\"\",\"tradingCountryAreaValue\":\"\",\"unloadingPort\":\"\",\"unloadingPortValue\":\"\",\"useOrgPersonCode\":\"\",\"useOrgPersonTel\":\"\",\"uses\":\"99\",\"usesValue\":\"其他\",\"withoutPaper\":\"\"}";
        System.out.println(filterBlankValue(jsonStr));
    }

}
