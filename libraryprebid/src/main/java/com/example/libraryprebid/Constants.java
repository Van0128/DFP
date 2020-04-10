/*
 *    Copyright 2018-2019 Prebid.org, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.example.libraryprebid;


public class Constants {
    private Constants() {
    }

    static final String AUTO_REFRESH_NAME = "autoRefresh";

    //AppNexus
    // Prebid server config ids
    private static final String PBS_ACCOUNT_ID_APPNEXUS = "e8df28e7-78ff-452d-b3af-ff4df83df832";
    private static final String PBS_CONFIG_ID_300x250_APPNEXUS = "ef6617e3-0300-4fd6-b64e-8c7bf880509d";
    private static final String PBS_CONFIG_ID_320x50_APPNEXUS = "625c6125-f19e-4d5b-95c5-55501526b2a4";
    private static final String PBS_CONFIG_ID_INTERSTITIAL_APPNEXUS = "625c6125-f19e-4d5b-95c5-55501526b2a4";
    private static final String PBS_CONFIG_ID_NATIVE_APPNEXUS = "25e17008-5081-4676-94d5-923ced4359d3";
    // DFP ad unit ids
    private static final String DFP_BANNER_ADUNIT_ID_300x250_APPNEXUS = "/307492156/Prebid_Display";
    private static final String DFP_BANNER_ADUNIT_ID_ALL_SIZES_APPNEXUS = "/19968336/PrebidMobileValidator_Banner_All_Sizes";
    private static final String DFP_INTERSTITIAL_ADUNIT_ID_APPNEXUS = "/19968336/PriceCheck_Interstitial";
    private static final String DFP_IN_BANNER_NATIVE_ADUNIT_ID_APPNEXUS = "/19968336/Wei_Prebid_Native_Test";
    //RubiconProject
    // Prebid server config id
    private static final String PBS_ACCOUNT_ID_RUBICON = "1001";
    private static final String PBS_CONFIG_ID_300x250_RUBICON = "1001-1";
    private static final String PBS_CONFIG_ID_INTERSTITIAL_RUBICON = "";

    // DFP ad unit ids
    private static final String DFP_BANNER_ADUNIT_ID_300x250_RUBICON = "/5300653/test_adunit_pavliuchyk_300x250_prebid-server.rubiconproject.com_puc";
    private static final String DFP_INTERSTITIAL_ADUNIT_ID_RUBICON = "";

    static String PBS_ACCOUNT_ID = PBS_ACCOUNT_ID_APPNEXUS;
    static String PBS_CONFIG_ID_300x250 = PBS_CONFIG_ID_300x250_APPNEXUS;
    static String PBS_CONFIG_ID_320x50 = PBS_CONFIG_ID_320x50_APPNEXUS;
    static String PBS_CONFIG_ID_INTERSTITIAL = PBS_CONFIG_ID_INTERSTITIAL_APPNEXUS;
    // DFP ad unit ids
    static String DFP_BANNER_ADUNIT_ID_300x250 = DFP_BANNER_ADUNIT_ID_300x250_APPNEXUS;
    static String DFP_BANNER_ADUNIT_ID_ALL_SIZES = DFP_BANNER_ADUNIT_ID_ALL_SIZES_APPNEXUS;
    static String DFP_INTERSTITIAL_ADUNIT_ID = DFP_INTERSTITIAL_ADUNIT_ID_APPNEXUS;



}
