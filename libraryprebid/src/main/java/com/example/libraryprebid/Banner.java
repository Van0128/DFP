package com.example.libraryprebid;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

import org.prebid.mobile.AdUnit;
import org.prebid.mobile.BannerAdUnit;
import org.prebid.mobile.Host;
import org.prebid.mobile.InterstitialAdUnit;
import org.prebid.mobile.OnCompleteListener;
import org.prebid.mobile.PrebidMobile;
import org.prebid.mobile.ResultCode;
import org.prebid.mobile.VideoAdUnit;
import org.prebid.mobile.VideoInterstitialAdUnit;
import org.prebid.mobile.addendum.AdViewUtils;
import org.prebid.mobile.addendum.PbFindSizeError;

public class Banner {
    private static int refresCount = 0;
    private static AdUnit adUnit;
    private static PublisherInterstitialAd amInterstitial;
    private static PublisherAdView amBanner;

    private static final ResultCode[] resultCode1 = new ResultCode[1];

    public static void mToast(Context context, String message) {
        Toast toast = Toast.makeText(context,message,Toast.LENGTH_LONG);
        View view = toast.getView();
        toast.show();
    }


    public static void Banner300x250Setup(Context context,String PBS_CONFIG_ID_300x250,FrameLayout adFrame){
        PrebidMobile.setPrebidServerHost(Host.APPNEXUS);
        PrebidMobile.setPrebidServerAccountId(Constants.PBS_ACCOUNT_ID);
        PrebidMobile.setStoredAuctionResponse("");
        adUnit = new BannerAdUnit(PBS_CONFIG_ID_300x250, 300, 250);


        amBanner = new PublisherAdView(context);
        amBanner.setAdUnitId(Constants.DFP_BANNER_ADUNIT_ID_300x250);
        amBanner.setAdSizes(new AdSize(300, 250));
        adFrame.removeAllViews();
        adFrame.addView(amBanner);

        amBanner.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();

                AdViewUtils.findPrebidCreativeSize(amBanner, new AdViewUtils.PbFindSizeListener() {
                    @Override
                    public void success(int width, int height) {
                        amBanner.setAdSizes(new AdSize(width, height));

                    }

                    @Override
                    public void failure(@NonNull PbFindSizeError error) {
                        Log.d("MyTag", "error: " + error);

                    }
                });

            }
        });
        final PublisherAdRequest.Builder builder = new PublisherAdRequest.Builder();
        final PublisherAdRequest request = builder.build();
        //region PrebidMobile Mobile API 1.0 usage
        adUnit.setAutoRefreshPeriodMillis(2);
        adUnit.fetchDemand(request, new OnCompleteListener() {
            @Override
            public void onComplete(ResultCode resultCode) {
                resultCode1[0] = resultCode;
                amBanner.loadAd(request);
                refresCount++;
            }
        });

    }
    public static void Banner320x50Setup(Context context,String PBS_CONFIG_ID_320x50,FrameLayout adFrame){
        PrebidMobile.setPrebidServerHost(Host.APPNEXUS);
        PrebidMobile.setPrebidServerAccountId(Constants.PBS_ACCOUNT_ID);
        PrebidMobile.setStoredAuctionResponse("");
        adUnit = new BannerAdUnit(PBS_CONFIG_ID_320x50, 320, 50);

        amBanner = new PublisherAdView(context);
        amBanner.setAdUnitId(Constants.DFP_BANNER_ADUNIT_ID_ALL_SIZES);
        amBanner.setAdSizes(new AdSize(300, 250));
        adFrame.removeAllViews();
        adFrame.addView(amBanner);

        amBanner.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();

                AdViewUtils.findPrebidCreativeSize(amBanner, new AdViewUtils.PbFindSizeListener() {
                    @Override
                    public void success(int width, int height) {
                        amBanner.setAdSizes(new AdSize(width, height));

                    }

                    @Override
                    public void failure(@NonNull PbFindSizeError error) {
                        Log.d("MyTag", "error: " + error);

                    }
                });

            }
        });
        final PublisherAdRequest.Builder builder = new PublisherAdRequest.Builder();
        final PublisherAdRequest request = builder.build();
        //region PrebidMobile Mobile API 1.0 usage
        adUnit.setAutoRefreshPeriodMillis(2);
        adUnit.fetchDemand(request, new OnCompleteListener() {
            @Override
            public void onComplete(ResultCode resultCode) {
                resultCode1[0] = resultCode;
                amBanner.loadAd(request);
                refresCount++;
            }
        });
    }

    public static void IntertitialSetup(Context context,String PBS_CONFIG_ID_INTERSTITIAL) {
        setupPBInterstitial(PBS_CONFIG_ID_INTERSTITIAL);
        setupAMInterstitial(context);
        loadInterstitial();
    }
    private static void setupPBInterstitial(String id) {
        PrebidMobile.setPrebidServerHost(Host.APPNEXUS);
        PrebidMobile.setPrebidServerAccountId(Constants.PBS_ACCOUNT_ID);
        PrebidMobile.setStoredAuctionResponse("");
        adUnit = new InterstitialAdUnit(id);
    }

    private static void setupAMInterstitial(final Context context, String id) {
        amInterstitial = new PublisherInterstitialAd(context);
        amInterstitial.setAdUnitId(id);
        amInterstitial.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                amInterstitial.show();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(context);
                }
                builder.setTitle("Failed to load DFP interstitial ad")
                        .setMessage("Error code: " + i)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }


    private static void setupAMInterstitial(Context context) {
        setupAMInterstitial(context,Constants.DFP_INTERSTITIAL_ADUNIT_ID);
    }

    private static void loadInterstitial() {
        adUnit.setAutoRefreshPeriodMillis(2);
        PublisherAdRequest.Builder builder = new PublisherAdRequest.Builder();
        final PublisherAdRequest request = builder.build();
        adUnit.fetchDemand(request, new OnCompleteListener() {
            @Override
            public void onComplete(ResultCode resultCode) {
                resultCode1[0] = resultCode;
                amInterstitial.loadAd(request);
                refresCount++;
            }
        });
    }

    public static void setupAndLoadAMBannerVAST(Context context ,String PBS_CONFIGID_300x250_RB, FrameLayout adframe) {
        setupPBBannerVAST(PBS_CONFIGID_300x250_RB);
        setupAMBannerVAST(context);
        loadBanner(adframe);
    }
    private static void setupPBBannerVAST(String id) {
        PrebidMobile.setPrebidServerHost(Host.RUBICON);
        PrebidMobile.setPrebidServerAccountId("1001");
        PrebidMobile.setStoredAuctionResponse("sample_video_response");

        adUnit = new VideoAdUnit(id, 300, 250, VideoAdUnit.PlacementType.IN_BANNER);
    }

    private static void setupAMBanner(int width, int height, String id, Context context) {
        amBanner = new PublisherAdView(context);
        amBanner.setAdUnitId(id);
        amBanner.setAdSizes(new AdSize(width, height));
    }

    private static void setupAMBannerVAST(Context context) {
        setupAMBanner(300, 250, "/5300653/test_adunit_vast_pavliuchyk",context);
    }
    private static void loadBanner(FrameLayout adFrame) {
        adFrame.removeAllViews();
        adFrame.addView(amBanner);

        amBanner.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();

                AdViewUtils.findPrebidCreativeSize(amBanner, new AdViewUtils.PbFindSizeListener() {
                    @Override
                    public void success(int width, int height) {
                        amBanner.setAdSizes(new AdSize(width, height));

                    }

                    @Override
                    public void failure(@NonNull PbFindSizeError error) {
                        Log.d("MyTag", "error: " + error);
                    }
                });

            }
        });

        final PublisherAdRequest.Builder builder = new PublisherAdRequest.Builder();
        final PublisherAdRequest request = builder.build();
        //region PrebidMobile Mobile API 1.0 usage
        adUnit.setAutoRefreshPeriodMillis(2);
        adUnit.fetchDemand(request, new OnCompleteListener() {
            @Override
            public void onComplete(ResultCode resultCode) {
                resultCode1[0] = resultCode;
                amBanner.loadAd(request);
                refresCount++;
            }
        });
    }

    public static void setupAndLoadAMInterstitialVAST(Context context,String PBS_INTERSTITIALVAST_ADUNIT_ID) {
        setupPBInterstitialVAST(PBS_INTERSTITIALVAST_ADUNIT_ID);
        setupAMInterstitialVAST(context);
        loadInterstitial();
    }
    private static void setupPBInterstitialVAST(String id) {
        PrebidMobile.setPrebidServerHost(Host.RUBICON);
        PrebidMobile.setPrebidServerAccountId("1001");
        PrebidMobile.setStoredAuctionResponse("sample_video_response");

        adUnit = new VideoInterstitialAdUnit(id);
    }
    private static void setupAMInterstitialVAST(Context context) {
        setupAMInterstitial(context, "/5300653/test_adunit_vast_pavliuchyk");
    }

    private void setupAMInterstitial(String id, final Context context) {
        amInterstitial = new PublisherInterstitialAd(context);
        amInterstitial.setAdUnitId(id);
        amInterstitial.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                amInterstitial.show();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(context);
                }
                builder.setTitle("Failed to load DFP interstitial ad")
                        .setMessage("Error code: " + i)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        });
    }

}
