// Foxit Quick PDF Library
// Android Edition
// Version 17.11

// Copyright (c) 1999 - 2019 Foxit Software

// DebenuPDFLibraryCPAndroidJava1711.java
// Android Java import class
// http://www.debenu.com/

package com.debenu.pdflibrary;

public class DebenuPDFLibraryCPAndroidJava1711 {

    private int InstanceID;
    private boolean LibraryLoaded;

    public final static native int DPLAddArcToPath(int jarg1, double jarg2, double jarg3, double jarg4);
    public final static native int DPLAddBoxToPath(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLAddCJKFont(int jarg1, int jarg2);
    public final static native int DPLAddCurveToPath(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, double jarg6, double jarg7);
    public final static native int DPLAddEmbeddedFile(int jarg1, String jarg2, String jarg3);
    public final static native int DPLAddEmbeddedFileA(int jarg1, String jarg2, String jarg3);
    public final static native int DPLAddFileAttachment(int jarg1, String jarg2, int jarg3);
    public final static native int DPLAddFileAttachmentA(int jarg1, String jarg2, int jarg3);
    public final static native int DPLAddFormFieldChoiceSub(int jarg1, int jarg2, String jarg3, String jarg4);
    public final static native int DPLAddFormFieldChoiceSubA(int jarg1, int jarg2, String jarg3, String jarg4);
    public final static native int DPLAddFormFieldSub(int jarg1, int jarg2, String jarg3);
    public final static native int DPLAddFormFieldSubA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLAddFormFont(int jarg1, int jarg2);
    public final static native int DPLAddFreeTextAnnotation(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7, int jarg8);
    public final static native int DPLAddFreeTextAnnotationA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7, int jarg8);
    public final static native int DPLAddFreeTextAnnotationEx(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7, int jarg8, int jarg9);
    public final static native int DPLAddFreeTextAnnotationExA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7, int jarg8, int jarg9);
    public final static native int DPLAddGlobalJavaScript(int jarg1, String jarg2, String jarg3);
    public final static native int DPLAddGlobalJavaScriptA(int jarg1, String jarg2, String jarg3);
    public final static native int DPLAddImageFromFile(int jarg1, String jarg2, int jarg3);
    public final static native int DPLAddImageFromFileA(int jarg1, String jarg2, int jarg3);
    public final static native int DPLAddImageFromFileOffset(int jarg1, String jarg2, int jarg3, int jarg4, int jarg5);
    public final static native int DPLAddImageFromFileOffsetA(int jarg1, String jarg2, int jarg3, int jarg4, int jarg5);
    public final static native int DPLAddImageFromString(int jarg1, byte[] jarg2, int jarg3);
    public final static native int DPLAddLGIDictToPage(int jarg1, String jarg2);
    public final static native int DPLAddLGIDictToPageA(int jarg1, String jarg2);
    public final static native int DPLAddLineToPath(int jarg1, double jarg2, double jarg3);
    public final static native int DPLAddLinkToDestination(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, int jarg6, int jarg7);
    public final static native int DPLAddLinkToEmbeddedFile(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, int jarg6, String jarg7, String jarg8, int jarg9, int jarg10);
    public final static native int DPLAddLinkToEmbeddedFileA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, int jarg6, String jarg7, String jarg8, int jarg9, int jarg10);
    public final static native int DPLAddLinkToFile(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7, double jarg8, int jarg9, int jarg10);
    public final static native int DPLAddLinkToFileA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7, double jarg8, int jarg9, int jarg10);
    public final static native int DPLAddLinkToFileDest(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, String jarg7, double jarg8, int jarg9, int jarg10);
    public final static native int DPLAddLinkToFileDestA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, String jarg7, double jarg8, int jarg9, int jarg10);
    public final static native int DPLAddLinkToFileEx(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7, int jarg8, int jarg9, int jarg10, int jarg11, double jarg12, double jarg13, double jarg14, double jarg15);
    public final static native int DPLAddLinkToFileExA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7, int jarg8, int jarg9, int jarg10, int jarg11, double jarg12, double jarg13, double jarg14, double jarg15);
    public final static native int DPLAddLinkToJavaScript(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7);
    public final static native int DPLAddLinkToJavaScriptA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7);
    public final static native int DPLAddLinkToLocalFile(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7);
    public final static native int DPLAddLinkToLocalFileA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7);
    public final static native int DPLAddLinkToPage(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, int jarg6, double jarg7, int jarg8);
    public final static native int DPLAddLinkToWeb(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7);
    public final static native int DPLAddLinkToWebA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7);
    public final static native int DPLAddNoteAnnotation(int jarg1, double jarg2, double jarg3, int jarg4, double jarg5, double jarg6, double jarg7, double jarg8, String jarg9, String jarg10, double jarg11, double jarg12, double jarg13, int jarg14);
    public final static native int DPLAddNoteAnnotationA(int jarg1, double jarg2, double jarg3, int jarg4, double jarg5, double jarg6, double jarg7, double jarg8, String jarg9, String jarg10, double jarg11, double jarg12, double jarg13, int jarg14);
    public final static native int DPLAddOpenTypeFontFromFile(int jarg1, String jarg2, int jarg3);
    public final static native int DPLAddOpenTypeFontFromFileA(int jarg1, String jarg2, int jarg3);
    public final static native int DPLAddOpenTypeFontFromString(int jarg1, byte[] jarg2, int jarg3);
    public final static native int DPLAddPageLabels(int jarg1, int jarg2, int jarg3, int jarg4, String jarg5);
    public final static native int DPLAddPageLabelsA(int jarg1, int jarg2, int jarg3, int jarg4, String jarg5);
    public final static native int DPLAddPageMatrix(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLAddRGBSeparationColor(int jarg1, String jarg2, double jarg3, double jarg4, double jarg5, int jarg6);
    public final static native int DPLAddRGBSeparationColorA(int jarg1, String jarg2, double jarg3, double jarg4, double jarg5, int jarg6);
    public final static native int DPLAddRelativeLinkToFile(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7, double jarg8, int jarg9, int jarg10);
    public final static native int DPLAddRelativeLinkToFileA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7, double jarg8, int jarg9, int jarg10);
    public final static native int DPLAddRelativeLinkToFileDest(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, String jarg7, double jarg8, int jarg9, int jarg10);
    public final static native int DPLAddRelativeLinkToFileDestA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, String jarg7, double jarg8, int jarg9, int jarg10);
    public final static native int DPLAddRelativeLinkToFileEx(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7, int jarg8, int jarg9, int jarg10, int jarg11, double jarg12, double jarg13, double jarg14, double jarg15);
    public final static native int DPLAddRelativeLinkToFileExA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7, int jarg8, int jarg9, int jarg10, int jarg11, double jarg12, double jarg13, double jarg14, double jarg15);
    public final static native int DPLAddRelativeLinkToLocalFile(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7);
    public final static native int DPLAddRelativeLinkToLocalFileA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7);
    public final static native int DPLAddSVGAnnotationFromFile(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7);
    public final static native int DPLAddSVGAnnotationFromFileA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7);
    public final static native int DPLAddSWFAnnotationFromFile(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, String jarg7, int jarg8);
    public final static native int DPLAddSWFAnnotationFromFileA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, String jarg7, int jarg8);
    public final static native int DPLAddSeparationColor(int jarg1, String jarg2, double jarg3, double jarg4, double jarg5, double jarg6, int jarg7);
    public final static native int DPLAddSeparationColorA(int jarg1, String jarg2, double jarg3, double jarg4, double jarg5, double jarg6, int jarg7);
    public final static native int DPLAddSignProcessOverlayText(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5, String jarg6, String jarg7);
    public final static native int DPLAddSignProcessOverlayTextA(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5, String jarg6, String jarg7);
    public final static native int DPLAddStampAnnotation(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, int jarg6, String jarg7, String jarg8, double jarg9, double jarg10, double jarg11, int jarg12);
    public final static native int DPLAddStampAnnotationA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, int jarg6, String jarg7, String jarg8, double jarg9, double jarg10, double jarg11, int jarg12);
    public final static native int DPLAddStampAnnotationFromImage(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, String jarg7, String jarg8, double jarg9, double jarg10, double jarg11, int jarg12);
    public final static native int DPLAddStampAnnotationFromImageA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, String jarg7, String jarg8, double jarg9, double jarg10, double jarg11, int jarg12);
    public final static native int DPLAddStampAnnotationFromImageID(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, int jarg6, String jarg7, String jarg8, double jarg9, double jarg10, double jarg11, int jarg12);
    public final static native int DPLAddStampAnnotationFromImageIDA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, int jarg6, String jarg7, String jarg8, double jarg9, double jarg10, double jarg11, int jarg12);
    public final static native int DPLAddStandardFont(int jarg1, int jarg2);
    public final static native int DPLAddSubsettedFont(int jarg1, String jarg2, int jarg3, String jarg4);
    public final static native int DPLAddSubsettedFontA(int jarg1, String jarg2, int jarg3, String jarg4);
    public final static native int DPLAddTextMarkupAnnotation(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5, double jarg6);
    public final static native int DPLAddToFileList(int jarg1, String jarg2, String jarg3);
    public final static native int DPLAddToFileListA(int jarg1, String jarg2, String jarg3);
    public final static native int DPLAddTrueTypeFont(int jarg1, String jarg2, int jarg3);
    public final static native int DPLAddTrueTypeFontA(int jarg1, String jarg2, int jarg3);
    public final static native int DPLAddTrueTypeFontFromFile(int jarg1, String jarg2);
    public final static native int DPLAddTrueTypeFontFromFileA(int jarg1, String jarg2);
    public final static native int DPLAddTrueTypeFontFromString(int jarg1, byte[] jarg2);
    public final static native int DPLAddTrueTypeFontFromStringEx(int jarg1, byte[] jarg2, int jarg3);
    public final static native int DPLAddTrueTypeSubsettedFont(int jarg1, String jarg2, String jarg3, int jarg4);
    public final static native int DPLAddTrueTypeSubsettedFontA(int jarg1, String jarg2, String jarg3, int jarg4);
    public final static native int DPLAddTrueTypeSubsettedFontFromFile(int jarg1, String jarg2, String jarg3, int jarg4);
    public final static native int DPLAddTrueTypeSubsettedFontFromFileA(int jarg1, String jarg2, String jarg3, int jarg4);
    public final static native int DPLAddTrueTypeSubsettedFontFromString(int jarg1, byte[] jarg2, String jarg3, int jarg4);
    public final static native int DPLAddTrueTypeSubsettedFontFromStringA(int jarg1, byte[] jarg2, String jarg3, int jarg4);
    public final static native int DPLAddType1Font(int jarg1, String jarg2);
    public final static native int DPLAddType1FontA(int jarg1, String jarg2);
    public final static native int DPLAddU3DAnnotationFromFile(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7);
    public final static native int DPLAddU3DAnnotationFromFileA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7);
    public final static native int DPLAnalyseFile(int jarg1, String jarg2, String jarg3);
    public final static native int DPLAnalyseFileA(int jarg1, String jarg2, String jarg3);
    public final static native int DPLAnnotationCount(int jarg1);
    public final static native int DPLAppendSpace(int jarg1, double jarg2);
    public final static native int DPLAppendTableColumns(int jarg1, int jarg2, int jarg3);
    public final static native int DPLAppendTableRows(int jarg1, int jarg2, int jarg3);
    public final static native int DPLAppendText(int jarg1, String jarg2);
    public final static native int DPLAppendTextA(int jarg1, String jarg2);
    public final static native int DPLAppendToFile(int jarg1, String jarg2);
    public final static native int DPLAppendToFileA(int jarg1, String jarg2);
    public final static native byte[] DPLAppendToString(int jarg1, int jarg2);
    public final static native int DPLApplyStyle(int jarg1, String jarg2);
    public final static native int DPLApplyStyleA(int jarg1, String jarg2);
    public final static native int DPLAttachAnnotToForm(int jarg1, int jarg2);
    public final static native int DPLBalanceContentStream(int jarg1);
    public final static native int DPLBalancePageTree(int jarg1, int jarg2);
    public final static native int DPLBeginPageUpdate(int jarg1);
    public final static native int DPLCapturePage(int jarg1, int jarg2);
    public final static native int DPLCapturePageEx(int jarg1, int jarg2, int jarg3);
    public final static native int DPLCharWidth(int jarg1, int jarg2);
    public final static native int DPLCheckFileCompliance(int jarg1, String jarg2, String jarg3, int jarg4, int jarg5);
    public final static native int DPLCheckFileComplianceA(int jarg1, String jarg2, String jarg3, int jarg4, int jarg5);
    public final static native int DPLCheckObjects(int jarg1);
    public final static native int DPLCheckPageAnnots(int jarg1);
    public final static native int DPLCheckPassword(int jarg1, String jarg2);
    public final static native int DPLCheckPasswordA(int jarg1, String jarg2);
    public final static native int DPLClearFileList(int jarg1, String jarg2);
    public final static native int DPLClearFileListA(int jarg1, String jarg2);
    public final static native int DPLClearImage(int jarg1, int jarg2);
    public final static native int DPLClearPageLabels(int jarg1);
    public final static native int DPLClearTextFormatting(int jarg1);
    public final static native int DPLCloneOutlineAction(int jarg1, int jarg2);
    public final static native int DPLClonePages(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLCloseOutline(int jarg1, int jarg2);
    public final static native int DPLClosePath(int jarg1);
    public final static native int DPLCombineContentStreams(int jarg1);
    public final static native int DPLCompareOutlines(int jarg1, int jarg2, int jarg3);
    public final static native int DPLCompressContent(int jarg1);
    public final static native int DPLCompressFonts(int jarg1, int jarg2);
    public final static native int DPLCompressImages(int jarg1, int jarg2);
    public final static native int DPLCompressPage(int jarg1);
    public final static native int DPLContentStreamCount(int jarg1);
    public final static native int DPLContentStreamSafe(int jarg1);
    public final static native int DPLCopyPageRanges(int jarg1, int jarg2, String jarg3);
    public final static native int DPLCopyPageRangesA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLCopyPageRangesEx(int jarg1, int jarg2, String jarg3, int jarg4);
    public final static native int DPLCopyPageRangesExA(int jarg1, int jarg2, String jarg3, int jarg4);
    public final static native int DPLCreateLibrary();
    public final static native int DPLCreateNewObject(int jarg1);
    public final static native int DPLCreateTable(int jarg1, int jarg2, int jarg3);
    public final static native int DPLDAAppendFile(int jarg1, int jarg2);
    public final static native int DPLDACapturePage(int jarg1, int jarg2, int jarg3);
    public final static native int DPLDACapturePageEx(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLDACloseFile(int jarg1, int jarg2);
    public final static native int DPLDADrawCapturedPage(int jarg1, int jarg2, int jarg3, int jarg4, double jarg5, double jarg6, double jarg7, double jarg8);
    public final static native int DPLDADrawRotatedCapturedPage(int jarg1, int jarg2, int jarg3, int jarg4, double jarg5, double jarg6, double jarg7, double jarg8, double jarg9);
    public final static native int DPLDAEmbedFileStreams(int jarg1, int jarg2, String jarg3);
    public final static native int DPLDAEmbedFileStreamsA(int jarg1, int jarg2, String jarg3);
    public final static native String DPLDAExtractPageText(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native String DPLDAExtractPageTextA(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLDAExtractPageTextBlocks(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLDAFindPage(int jarg1, int jarg2, int jarg3);
    public final static native int DPLDAGetAnnotationCount(int jarg1, int jarg2, int jarg3);
    public final static native int DPLDAGetFormFieldCount(int jarg1, int jarg2);
    public final static native String DPLDAGetFormFieldTitle(int jarg1, int jarg2, int jarg3);
    public final static native String DPLDAGetFormFieldTitleA(int jarg1, int jarg2, int jarg3);
    public final static native String DPLDAGetFormFieldValue(int jarg1, int jarg2, int jarg3);
    public final static native String DPLDAGetFormFieldValueA(int jarg1, int jarg2, int jarg3);
    public final static native byte[] DPLDAGetImageDataToString(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native double DPLDAGetImageDblProperty(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5);
    public final static native int DPLDAGetImageIntProperty(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5);
    public final static native int DPLDAGetImageListCount(int jarg1, int jarg2, int jarg3);
    public final static native String DPLDAGetInformation(int jarg1, int jarg2, String jarg3);
    public final static native String DPLDAGetInformationA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLDAGetObjectCount(int jarg1, int jarg2);
    public final static native byte[] DPLDAGetObjectToString(int jarg1, int jarg2, int jarg3);
    public final static native double DPLDAGetPageBox(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5);
    public final static native byte[] DPLDAGetPageContentToString(int jarg1, int jarg2, int jarg3);
    public final static native int DPLDAGetPageCount(int jarg1, int jarg2);
    public final static native double DPLDAGetPageHeight(int jarg1, int jarg2, int jarg3);
    public final static native int DPLDAGetPageImageList(int jarg1, int jarg2, int jarg3);
    public final static native int DPLDAGetPageLayout(int jarg1, int jarg2);
    public final static native int DPLDAGetPageMode(int jarg1, int jarg2);
    public final static native double DPLDAGetPageWidth(int jarg1, int jarg2, int jarg3);
    public final static native String DPLDAGetTextBlockAsString(int jarg1, int jarg2, int jarg3);
    public final static native String DPLDAGetTextBlockAsStringA(int jarg1, int jarg2, int jarg3);
    public final static native double DPLDAGetTextBlockBound(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native double DPLDAGetTextBlockCharWidth(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native double DPLDAGetTextBlockColor(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLDAGetTextBlockColorType(int jarg1, int jarg2, int jarg3);
    public final static native int DPLDAGetTextBlockCount(int jarg1, int jarg2);
    public final static native String DPLDAGetTextBlockFontName(int jarg1, int jarg2, int jarg3);
    public final static native String DPLDAGetTextBlockFontNameA(int jarg1, int jarg2, int jarg3);
    public final static native double DPLDAGetTextBlockFontSize(int jarg1, int jarg2, int jarg3);
    public final static native String DPLDAGetTextBlockText(int jarg1, int jarg2, int jarg3);
    public final static native String DPLDAGetTextBlockTextA(int jarg1, int jarg2, int jarg3);
    public final static native int DPLDAHasPageBox(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLDAHidePage(int jarg1, int jarg2, int jarg3);
    public final static native int DPLDAMovePage(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5);
    public final static native int DPLDANewPage(int jarg1, int jarg2);
    public final static native int DPLDANewPages(int jarg1, int jarg2, int jarg3);
    public final static native int DPLDANormalizePage(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLDAOpenFile(int jarg1, String jarg2, String jarg3);
    public final static native int DPLDAOpenFileA(int jarg1, String jarg2, String jarg3);
    public final static native int DPLDAOpenFileReadOnly(int jarg1, String jarg2, String jarg3);
    public final static native int DPLDAOpenFileReadOnlyA(int jarg1, String jarg2, String jarg3);
    public final static native int DPLDAPageRotation(int jarg1, int jarg2, int jarg3);
    public final static native int DPLDAReleaseImageList(int jarg1, int jarg2, int jarg3);
    public final static native int DPLDAReleaseTextBlocks(int jarg1, int jarg2);
    public final static native int DPLDARemoveUsageRights(int jarg1, int jarg2);
    public final static native int DPLDARenderPageToFile(int jarg1, int jarg2, int jarg3, int jarg4, double jarg5, String jarg6);
    public final static native int DPLDARenderPageToFileA(int jarg1, int jarg2, int jarg3, int jarg4, double jarg5, String jarg6);
    public final static native byte[] DPLDARenderPageToString(int jarg1, int jarg2, int jarg3, int jarg4, double jarg5);
    public final static native int DPLDARotatePage(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5);
    public final static native int DPLDASaveAsFile(int jarg1, int jarg2, String jarg3);
    public final static native int DPLDASaveAsFileA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLDASaveImageDataToFile(int jarg1, int jarg2, int jarg3, int jarg4, String jarg5);
    public final static native int DPLDASaveImageDataToFileA(int jarg1, int jarg2, int jarg3, int jarg4, String jarg5);
    public final static native int DPLDASetInformation(int jarg1, int jarg2, String jarg3, String jarg4);
    public final static native int DPLDASetInformationA(int jarg1, int jarg2, String jarg3, String jarg4);
    public final static native int DPLDASetPageBox(int jarg1, int jarg2, int jarg3, int jarg4, double jarg5, double jarg6, double jarg7, double jarg8);
    public final static native int DPLDASetPageLayout(int jarg1, int jarg2, int jarg3);
    public final static native int DPLDASetPageMode(int jarg1, int jarg2, int jarg3);
    public final static native int DPLDASetPageSize(int jarg1, int jarg2, int jarg3, double jarg4, double jarg5);
    public final static native int DPLDASetRenderArea(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLDASetTextExtractionArea(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLDASetTextExtractionOptions(int jarg1, int jarg2, int jarg3);
    public final static native int DPLDASetTextExtractionScaling(int jarg1, int jarg2, double jarg3, double jarg4);
    public final static native int DPLDASetTextExtractionWordGap(int jarg1, double jarg2);
    public final static native int DPLDAShiftedHeader(int jarg1, int jarg2);
    public final static native int DPLDecrypt(int jarg1);
    public final static native int DPLDecryptFile(int jarg1, String jarg2, String jarg3, String jarg4);
    public final static native int DPLDecryptFileA(int jarg1, String jarg2, String jarg3, String jarg4);
    public final static native int DPLDeleteAnalysis(int jarg1, int jarg2);
    public final static native int DPLDeleteAnnotation(int jarg1, int jarg2);
    public final static native int DPLDeleteContentStream(int jarg1);
    public final static native int DPLDeleteFormField(int jarg1, int jarg2);
    public final static native int DPLDeleteOptionalContentGroup(int jarg1, int jarg2);
    public final static native int DPLDeletePageLGIDict(int jarg1, int jarg2);
    public final static native int DPLDeletePages(int jarg1, int jarg2, int jarg3);
    public final static native int DPLDocJavaScriptAction(int jarg1, String jarg2, String jarg3);
    public final static native int DPLDocJavaScriptActionA(int jarg1, String jarg2, String jarg3);
    public final static native int DPLDocumentCount(int jarg1);
    public final static native int DPLDrawArc(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, double jarg6, int jarg7, int jarg8);
    public final static native int DPLDrawBarcode(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7, int jarg8);
    public final static native int DPLDrawBarcodeA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7, int jarg8);
    public final static native int DPLDrawBox(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, int jarg6);
    public final static native int DPLDrawCapturedPage(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5, double jarg6);
    public final static native int DPLDrawCapturedPageMatrix(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5, double jarg6, double jarg7, double jarg8);
    public final static native int DPLDrawCircle(int jarg1, double jarg2, double jarg3, double jarg4, int jarg5);
    public final static native int DPLDrawDataMatrixSymbol(int jarg1, double jarg2, double jarg3, double jarg4, String jarg5, int jarg6, int jarg7, int jarg8);
    public final static native int DPLDrawDataMatrixSymbolA(int jarg1, double jarg2, double jarg3, double jarg4, String jarg5, int jarg6, int jarg7, int jarg8);
    public final static native int DPLDrawEllipse(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, int jarg6);
    public final static native int DPLDrawEllipticArc(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, double jarg6, double jarg7, int jarg8, int jarg9);
    public final static native int DPLDrawHTMLText(int jarg1, double jarg2, double jarg3, double jarg4, String jarg5);
    public final static native int DPLDrawHTMLTextA(int jarg1, double jarg2, double jarg3, double jarg4, String jarg5);
    public final static native String DPLDrawHTMLTextBox(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6);
    public final static native String DPLDrawHTMLTextBoxA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6);
    public final static native String DPLDrawHTMLTextBoxMatrix(int jarg1, double jarg2, double jarg3, String jarg4, double jarg5, double jarg6, double jarg7, double jarg8, double jarg9, double jarg10);
    public final static native String DPLDrawHTMLTextBoxMatrixA(int jarg1, double jarg2, double jarg3, String jarg4, double jarg5, double jarg6, double jarg7, double jarg8, double jarg9, double jarg10);
    public final static native int DPLDrawHTMLTextMatrix(int jarg1, double jarg2, String jarg3, double jarg4, double jarg5, double jarg6, double jarg7, double jarg8, double jarg9);
    public final static native int DPLDrawHTMLTextMatrixA(int jarg1, double jarg2, String jarg3, double jarg4, double jarg5, double jarg6, double jarg7, double jarg8, double jarg9);
    public final static native int DPLDrawImage(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLDrawImageMatrix(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, double jarg6, double jarg7);
    public final static native int DPLDrawIntelligentMailBarcode(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, double jarg6, double jarg7, String jarg8, int jarg9);
    public final static native int DPLDrawIntelligentMailBarcodeA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, double jarg6, double jarg7, String jarg8, int jarg9);
    public final static native int DPLDrawLine(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLDrawMultiLineText(int jarg1, double jarg2, double jarg3, String jarg4, String jarg5);
    public final static native int DPLDrawMultiLineTextA(int jarg1, double jarg2, double jarg3, String jarg4, String jarg5);
    public final static native int DPLDrawPDF417Symbol(int jarg1, double jarg2, double jarg3, String jarg4, int jarg5);
    public final static native int DPLDrawPDF417SymbolA(int jarg1, double jarg2, double jarg3, String jarg4, int jarg5);
    public final static native int DPLDrawPDF417SymbolEx(int jarg1, double jarg2, double jarg3, String jarg4, int jarg5, int jarg6, int jarg7, int jarg8, double jarg9, double jarg10);
    public final static native int DPLDrawPDF417SymbolExA(int jarg1, double jarg2, double jarg3, String jarg4, int jarg5, int jarg6, int jarg7, int jarg8, double jarg9, double jarg10);
    public final static native int DPLDrawPath(int jarg1, int jarg2);
    public final static native int DPLDrawPathEvenOdd(int jarg1, int jarg2);
    public final static native int DPLDrawPostScriptXObject(int jarg1, int jarg2);
    public final static native int DPLDrawQRCode(int jarg1, double jarg2, double jarg3, double jarg4, String jarg5, int jarg6, int jarg7);
    public final static native int DPLDrawQRCodeA(int jarg1, double jarg2, double jarg3, double jarg4, String jarg5, int jarg6, int jarg7);
    public final static native int DPLDrawRotatedBox(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, double jarg6, int jarg7);
    public final static native int DPLDrawRotatedCapturedPage(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5, double jarg6, double jarg7);
    public final static native int DPLDrawRotatedImage(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, double jarg6);
    public final static native int DPLDrawRotatedMultiLineText(int jarg1, double jarg2, double jarg3, double jarg4, String jarg5, String jarg6);
    public final static native int DPLDrawRotatedMultiLineTextA(int jarg1, double jarg2, double jarg3, double jarg4, String jarg5, String jarg6);
    public final static native int DPLDrawRotatedText(int jarg1, double jarg2, double jarg3, double jarg4, String jarg5);
    public final static native int DPLDrawRotatedTextA(int jarg1, double jarg2, double jarg3, double jarg4, String jarg5);
    public final static native int DPLDrawRotatedTextBox(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, double jarg6, String jarg7, int jarg8);
    public final static native int DPLDrawRotatedTextBoxA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, double jarg6, String jarg7, int jarg8);
    public final static native int DPLDrawRotatedTextBoxEx(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, double jarg6, String jarg7, int jarg8, int jarg9, int jarg10, int jarg11);
    public final static native int DPLDrawRotatedTextBoxExA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, double jarg6, String jarg7, int jarg8, int jarg9, int jarg10, int jarg11);
    public final static native int DPLDrawRoundedBox(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, double jarg6, int jarg7);
    public final static native int DPLDrawRoundedRotatedBox(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, double jarg6, double jarg7, int jarg8);
    public final static native int DPLDrawScaledImage(int jarg1, double jarg2, double jarg3, double jarg4);
    public final static native int DPLDrawSpacedText(int jarg1, double jarg2, double jarg3, double jarg4, String jarg5);
    public final static native int DPLDrawSpacedTextA(int jarg1, double jarg2, double jarg3, double jarg4, String jarg5);
    public final static native double DPLDrawTableRows(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5, int jarg6, int jarg7);
    public final static native int DPLDrawText(int jarg1, double jarg2, double jarg3, String jarg4);
    public final static native int DPLDrawTextA(int jarg1, double jarg2, double jarg3, String jarg4);
    public final static native int DPLDrawTextArc(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7);
    public final static native int DPLDrawTextArcA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7);
    public final static native int DPLDrawTextBox(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7);
    public final static native int DPLDrawTextBoxA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7);
    public final static native int DPLDrawTextBoxMatrix(int jarg1, double jarg2, double jarg3, String jarg4, int jarg5, double jarg6, double jarg7, double jarg8, double jarg9, double jarg10, double jarg11);
    public final static native int DPLDrawTextBoxMatrixA(int jarg1, double jarg2, double jarg3, String jarg4, int jarg5, double jarg6, double jarg7, double jarg8, double jarg9, double jarg10, double jarg11);
    public final static native int DPLDrawWrappedText(int jarg1, double jarg2, double jarg3, double jarg4, String jarg5);
    public final static native int DPLDrawWrappedTextA(int jarg1, double jarg2, double jarg3, double jarg4, String jarg5);
    public final static native int DPLEditableContentStream(int jarg1);
    public final static native int DPLEmbedFile(int jarg1, String jarg2, String jarg3, String jarg4);
    public final static native int DPLEmbedFileA(int jarg1, String jarg2, String jarg3, String jarg4);
    public final static native int DPLEmbedRelatedFile(int jarg1, String jarg2, String jarg3, String jarg4, String jarg5, int jarg6);
    public final static native int DPLEmbedRelatedFileA(int jarg1, String jarg2, String jarg3, String jarg4, String jarg5, int jarg6);
    public final static native int DPLEmbeddedFileCount(int jarg1);
    public final static native int DPLEncapsulateContentStream(int jarg1);
    public final static native int DPLEncodePermissions(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5, int jarg6, int jarg7, int jarg8, int jarg9);
    public final static native int DPLEncrypt(int jarg1, String jarg2, String jarg3, int jarg4, int jarg5);
    public final static native int DPLEncryptA(int jarg1, String jarg2, String jarg3, int jarg4, int jarg5);
    public final static native int DPLEncryptFile(int jarg1, String jarg2, String jarg3, String jarg4, String jarg5, int jarg6, int jarg7);
    public final static native int DPLEncryptFileA(int jarg1, String jarg2, String jarg3, String jarg4, String jarg5, int jarg6, int jarg7);
    public final static native int DPLEncryptWithFingerprint(int jarg1, String jarg2);
    public final static native int DPLEncryptWithFingerprintA(int jarg1, String jarg2);
    public final static native int DPLEncryptionAlgorithm(int jarg1);
    public final static native int DPLEncryptionStatus(int jarg1);
    public final static native int DPLEncryptionStrength(int jarg1);
    public final static native int DPLEndPageUpdate(int jarg1);
    public final static native int DPLEndSignProcessToFile(int jarg1, int jarg2, String jarg3);
    public final static native int DPLEndSignProcessToFileA(int jarg1, int jarg2, String jarg3);
    public final static native byte[] DPLEndSignProcessToString(int jarg1, int jarg2);
    public final static native byte[] DPLExtractFilePageContentToString(int jarg1, String jarg2, String jarg3, int jarg4);
    public final static native byte[] DPLExtractFilePageContentToStringA(int jarg1, String jarg2, String jarg3, int jarg4);
    public final static native String DPLExtractFilePageText(int jarg1, String jarg2, String jarg3, int jarg4, int jarg5);
    public final static native String DPLExtractFilePageTextA(int jarg1, String jarg2, String jarg3, int jarg4, int jarg5);
    public final static native int DPLExtractFilePageTextBlocks(int jarg1, String jarg2, String jarg3, int jarg4, int jarg5);
    public final static native int DPLExtractFilePageTextBlocksA(int jarg1, String jarg2, String jarg3, int jarg4, int jarg5);
    public final static native int DPLExtractFilePages(int jarg1, String jarg2, String jarg3, String jarg4, String jarg5);
    public final static native int DPLExtractFilePagesA(int jarg1, String jarg2, String jarg3, String jarg4, String jarg5);
    public final static native int DPLExtractFilePagesEx(int jarg1, String jarg2, String jarg3, String jarg4, String jarg5, int jarg6);
    public final static native int DPLExtractFilePagesExA(int jarg1, String jarg2, String jarg3, String jarg4, String jarg5, int jarg6);
    public final static native int DPLExtractPageRanges(int jarg1, String jarg2);
    public final static native int DPLExtractPageRangesA(int jarg1, String jarg2);
    public final static native int DPLExtractPageTextBlocks(int jarg1, int jarg2);
    public final static native int DPLExtractPages(int jarg1, int jarg2, int jarg3);
    public final static native int DPLFileListCount(int jarg1, String jarg2);
    public final static native int DPLFileListCountA(int jarg1, String jarg2);
    public final static native String DPLFileListItem(int jarg1, String jarg2, int jarg3);
    public final static native String DPLFileListItemA(int jarg1, String jarg2, int jarg3);
    public final static native int DPLFindFonts(int jarg1);
    public final static native int DPLFindFormFieldByTitle(int jarg1, String jarg2);
    public final static native int DPLFindFormFieldByTitleA(int jarg1, String jarg2);
    public final static native int DPLFindImages(int jarg1);
    public final static native int DPLFitImage(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, int jarg6, int jarg7, int jarg8);
    public final static native int DPLFitRotatedTextBox(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, double jarg6, String jarg7, int jarg8);
    public final static native int DPLFitRotatedTextBoxA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, double jarg6, String jarg7, int jarg8);
    public final static native int DPLFitTextBox(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7);
    public final static native int DPLFitTextBoxA(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, String jarg6, int jarg7);
    public final static native int DPLFlattenAllFormFields(int jarg1, int jarg2);
    public final static native int DPLFlattenAnnot(int jarg1, int jarg2, int jarg3);
    public final static native int DPLFlattenFormField(int jarg1, int jarg2);
    public final static native int DPLFontCount(int jarg1);
    public final static native String DPLFontFamily(int jarg1);
    public final static native String DPLFontFamilyA(int jarg1);
    public final static native int DPLFontHasKerning(int jarg1);
    public final static native String DPLFontName(int jarg1);
    public final static native String DPLFontNameA(int jarg1);
    public final static native String DPLFontReference(int jarg1);
    public final static native String DPLFontReferenceA(int jarg1);
    public final static native int DPLFontSize(int jarg1);
    public final static native int DPLFontType(int jarg1);
    public final static native int DPLFormFieldCount(int jarg1);
    public final static native int DPLFormFieldHasParent(int jarg1, int jarg2);
    public final static native int DPLFormFieldJavaScriptAction(int jarg1, int jarg2, String jarg3, String jarg4);
    public final static native int DPLFormFieldJavaScriptActionA(int jarg1, int jarg2, String jarg3, String jarg4);
    public final static native int DPLFormFieldWebLinkAction(int jarg1, int jarg2, String jarg3, String jarg4);
    public final static native int DPLFormFieldWebLinkActionA(int jarg1, int jarg2, String jarg3, String jarg4);
    public final static native int DPLGetActionDest(int jarg1, int jarg2);
    public final static native String DPLGetActionType(int jarg1, int jarg2);
    public final static native String DPLGetActionTypeA(int jarg1, int jarg2);
    public final static native String DPLGetActionURL(int jarg1, int jarg2);
    public final static native String DPLGetActionURLA(int jarg1, int jarg2);
    public final static native String DPLGetAnalysisInfo(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetAnalysisInfoA(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetAnnotActionID(int jarg1, int jarg2);
    public final static native double DPLGetAnnotDblProperty(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetAnnotDest(int jarg1, int jarg2);
    public final static native String DPLGetAnnotEmbeddedFileName(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetAnnotEmbeddedFileNameA(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetAnnotEmbeddedFileToFile(int jarg1, int jarg2, int jarg3, String jarg4);
    public final static native int DPLGetAnnotEmbeddedFileToFileA(int jarg1, int jarg2, int jarg3, String jarg4);
    public final static native byte[] DPLGetAnnotEmbeddedFileToString(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetAnnotIntProperty(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetAnnotQuadCount(int jarg1, int jarg2);
    public final static native double DPLGetAnnotQuadPoints(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLGetAnnotSoundToFile(int jarg1, int jarg2, int jarg3, String jarg4);
    public final static native int DPLGetAnnotSoundToFileA(int jarg1, int jarg2, int jarg3, String jarg4);
    public final static native byte[] DPLGetAnnotSoundToString(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetAnnotStrProperty(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetAnnotStrPropertyA(int jarg1, int jarg2, int jarg3);
    public final static native double DPLGetBarcodeWidth(int jarg1, double jarg2, String jarg3, int jarg4);
    public final static native double DPLGetBarcodeWidthA(int jarg1, double jarg2, String jarg3, int jarg4);
    public final static native String DPLGetBaseURL(int jarg1);
    public final static native String DPLGetBaseURLA(int jarg1);
    public final static native int DPLGetCSDictEPSG(int jarg1, int jarg2);
    public final static native int DPLGetCSDictType(int jarg1, int jarg2);
    public final static native String DPLGetCSDictWKT(int jarg1, int jarg2);
    public final static native String DPLGetCSDictWKTA(int jarg1, int jarg2);
    public final static native String DPLGetCatalogInformation(int jarg1, String jarg2);
    public final static native String DPLGetCatalogInformationA(int jarg1, String jarg2);
    public final static native byte[] DPLGetContentStreamToString(int jarg1);
    public final static native String DPLGetCustomInformation(int jarg1, String jarg2);
    public final static native String DPLGetCustomInformationA(int jarg1, String jarg2);
    public final static native String DPLGetCustomKeys(int jarg1, int jarg2);
    public final static native String DPLGetCustomKeysA(int jarg1, int jarg2);
    public final static native String DPLGetDestName(int jarg1, int jarg2);
    public final static native String DPLGetDestNameA(int jarg1, int jarg2);
    public final static native int DPLGetDestPage(int jarg1, int jarg2);
    public final static native int DPLGetDestType(int jarg1, int jarg2);
    public final static native double DPLGetDestValue(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetDocJavaScript(int jarg1, String jarg2);
    public final static native String DPLGetDocJavaScriptA(int jarg1, String jarg2);
    public final static native String DPLGetDocumentFileName(int jarg1);
    public final static native String DPLGetDocumentFileNameA(int jarg1);
    public final static native int DPLGetDocumentFileSize(int jarg1);
    public final static native int DPLGetDocumentID(int jarg1, int jarg2);
    public final static native String DPLGetDocumentIdentifier(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetDocumentIdentifierA(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetDocumentMetadata(int jarg1);
    public final static native String DPLGetDocumentMetadataA(int jarg1);
    public final static native int DPLGetDocumentRepaired(int jarg1);
    public final static native String DPLGetDocumentResourceList(int jarg1);
    public final static native String DPLGetDocumentResourceListA(int jarg1);
    public final static native int DPLGetEmbeddedFileContentToFile(int jarg1, int jarg2, String jarg3);
    public final static native int DPLGetEmbeddedFileContentToFileA(int jarg1, int jarg2, String jarg3);
    public final static native byte[] DPLGetEmbeddedFileContentToString(int jarg1, int jarg2);
    public final static native int DPLGetEmbeddedFileID(int jarg1, int jarg2);
    public final static native int DPLGetEmbeddedFileIntProperty(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetEmbeddedFileStrProperty(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetEmbeddedFileStrPropertyA(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetEncryptionFingerprint(int jarg1);
    public final static native String DPLGetEncryptionFingerprintA(int jarg1);
    public final static native String DPLGetFileMetadata(int jarg1, String jarg2, String jarg3);
    public final static native String DPLGetFileMetadataA(int jarg1, String jarg2, String jarg3);
    public final static native int DPLGetFirstChildOutline(int jarg1, int jarg2);
    public final static native int DPLGetFirstOutline(int jarg1);
    public final static native byte[] DPLGetFontCharacterCodesToString(int jarg1, String jarg2);
    public final static native byte[] DPLGetFontCharacterCodesToStringA(int jarg1, String jarg2);
    public final static native int DPLGetFontEncoding(int jarg1);
    public final static native int DPLGetFontFlags(int jarg1, int jarg2);
    public final static native int DPLGetFontID(int jarg1, int jarg2);
    public final static native int DPLGetFontIsEmbedded(int jarg1);
    public final static native int DPLGetFontIsSubsetted(int jarg1);
    public final static native int DPLGetFontMetrics(int jarg1, int jarg2);
    public final static native int DPLGetFontObjectNumber(int jarg1);
    public final static native int DPLGetFormFieldActionID(int jarg1, int jarg2, String jarg3);
    public final static native int DPLGetFormFieldActionIDA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLGetFormFieldAlignment(int jarg1, int jarg2);
    public final static native int DPLGetFormFieldAnnotFlags(int jarg1, int jarg2);
    public final static native double DPLGetFormFieldBackgroundColor(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetFormFieldBackgroundColorType(int jarg1, int jarg2);
    public final static native double DPLGetFormFieldBorderColor(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetFormFieldBorderColorType(int jarg1, int jarg2);
    public final static native double DPLGetFormFieldBorderProperty(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetFormFieldBorderStyle(int jarg1, int jarg2);
    public final static native double DPLGetFormFieldBound(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetFormFieldCaption(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldCaptionA(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldCaptionEx(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetFormFieldCaptionExA(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetFormFieldCheckStyle(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldChildTitle(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldChildTitleA(int jarg1, int jarg2);
    public final static native int DPLGetFormFieldChoiceType(int jarg1, int jarg2);
    public final static native double DPLGetFormFieldColor(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetFormFieldComb(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldDefaultValue(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldDefaultValueA(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldDescription(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldDescriptionA(int jarg1, int jarg2);
    public final static native int DPLGetFormFieldFlags(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldFontName(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldFontNameA(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldJavaScript(int jarg1, int jarg2, String jarg3);
    public final static native String DPLGetFormFieldJavaScriptA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLGetFormFieldKidCount(int jarg1, int jarg2);
    public final static native int DPLGetFormFieldKidTempIndex(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetFormFieldMaxLen(int jarg1, int jarg2);
    public final static native int DPLGetFormFieldNoExport(int jarg1, int jarg2);
    public final static native int DPLGetFormFieldPage(int jarg1, int jarg2);
    public final static native int DPLGetFormFieldPrintable(int jarg1, int jarg2);
    public final static native int DPLGetFormFieldReadOnly(int jarg1, int jarg2);
    public final static native int DPLGetFormFieldRequired(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldRichTextString(int jarg1, int jarg2, String jarg3);
    public final static native String DPLGetFormFieldRichTextStringA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLGetFormFieldRotation(int jarg1, int jarg2);
    public final static native int DPLGetFormFieldSubCount(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldSubDisplayName(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetFormFieldSubDisplayNameA(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetFormFieldSubName(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetFormFieldSubNameA(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetFormFieldSubmitActionString(int jarg1, int jarg2, String jarg3);
    public final static native String DPLGetFormFieldSubmitActionStringA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLGetFormFieldTabOrder(int jarg1, int jarg2);
    public final static native int DPLGetFormFieldTabOrderEx(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetFormFieldTextFlags(int jarg1, int jarg2, int jarg3);
    public final static native double DPLGetFormFieldTextSize(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldTitle(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldTitleA(int jarg1, int jarg2);
    public final static native int DPLGetFormFieldType(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldValue(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldValueA(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldValueByTitle(int jarg1, String jarg2);
    public final static native String DPLGetFormFieldValueByTitleA(int jarg1, String jarg2);
    public final static native int DPLGetFormFieldVisible(int jarg1, int jarg2);
    public final static native String DPLGetFormFieldWebLink(int jarg1, int jarg2, String jarg3);
    public final static native String DPLGetFormFieldWebLinkA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLGetFormFontCount(int jarg1);
    public final static native String DPLGetFormFontName(int jarg1, int jarg2);
    public final static native String DPLGetFormFontNameA(int jarg1, int jarg2);
    public final static native String DPLGetGlobalJavaScript(int jarg1, String jarg2);
    public final static native String DPLGetGlobalJavaScriptA(int jarg1, String jarg2);
    public final static native double DPLGetHTMLTextHeight(int jarg1, double jarg2, String jarg3);
    public final static native double DPLGetHTMLTextHeightA(int jarg1, double jarg2, String jarg3);
    public final static native int DPLGetHTMLTextLineCount(int jarg1, double jarg2, String jarg3);
    public final static native int DPLGetHTMLTextLineCountA(int jarg1, double jarg2, String jarg3);
    public final static native double DPLGetHTMLTextWidth(int jarg1, double jarg2, String jarg3);
    public final static native double DPLGetHTMLTextWidthA(int jarg1, double jarg2, String jarg3);
    public final static native int DPLGetImageID(int jarg1, int jarg2);
    public final static native int DPLGetImageListCount(int jarg1, int jarg2);
    public final static native byte[] DPLGetImageListItemDataToString(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native double DPLGetImageListItemDblProperty(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native String DPLGetImageListItemFormatDesc(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native String DPLGetImageListItemFormatDescA(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLGetImageListItemIntProperty(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLGetImageMeasureDict(int jarg1);
    public final static native int DPLGetImagePageCount(int jarg1, String jarg2);
    public final static native int DPLGetImagePageCountA(int jarg1, String jarg2);
    public final static native int DPLGetImagePageCountFromString(int jarg1, byte[] jarg2);
    public final static native int DPLGetImagePtDataDict(int jarg1);
    public final static native String DPLGetInformation(int jarg1, int jarg2);
    public final static native String DPLGetInformationA(int jarg1, int jarg2);
    public final static native String DPLGetInstalledFontsByCharset(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetInstalledFontsByCharsetA(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetInstalledFontsByCodePage(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetInstalledFontsByCodePageA(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetKerning(int jarg1, String jarg2);
    public final static native int DPLGetKerningA(int jarg1, String jarg2);
    public final static native int DPLGetMaxObjectNumber(int jarg1);
    public final static native int DPLGetMeasureDictBoundsCount(int jarg1, int jarg2);
    public final static native double DPLGetMeasureDictBoundsItem(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetMeasureDictCoordinateSystem(int jarg1, int jarg2);
    public final static native int DPLGetMeasureDictDCSDict(int jarg1, int jarg2);
    public final static native int DPLGetMeasureDictGCSDict(int jarg1, int jarg2);
    public final static native int DPLGetMeasureDictGPTSCount(int jarg1, int jarg2);
    public final static native double DPLGetMeasureDictGPTSItem(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetMeasureDictLPTSCount(int jarg1, int jarg2);
    public final static native double DPLGetMeasureDictLPTSItem(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetMeasureDictPDU(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetMeasurementUnits(int jarg1);
    public final static native int DPLGetNamedDestination(int jarg1, String jarg2);
    public final static native int DPLGetNamedDestinationA(int jarg1, String jarg2);
    public final static native int DPLGetNeedAppearances(int jarg1);
    public final static native int DPLGetNextOutline(int jarg1, int jarg2);
    public final static native int DPLGetObjectCount(int jarg1);
    public final static native int DPLGetObjectDecodeError(int jarg1, int jarg2);
    public final static native byte[] DPLGetObjectToString(int jarg1, int jarg2);
    public final static native int DPLGetOpenActionDestination(int jarg1);
    public final static native String DPLGetOpenActionJavaScript(int jarg1);
    public final static native String DPLGetOpenActionJavaScriptA(int jarg1);
    public final static native int DPLGetOptionalContentConfigCount(int jarg1);
    public final static native int DPLGetOptionalContentConfigLocked(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetOptionalContentConfigOrderCount(int jarg1, int jarg2);
    public final static native int DPLGetOptionalContentConfigOrderItemID(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetOptionalContentConfigOrderItemLabel(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetOptionalContentConfigOrderItemLabelA(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetOptionalContentConfigOrderItemLevel(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetOptionalContentConfigOrderItemType(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetOptionalContentConfigState(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetOptionalContentGroupID(int jarg1, int jarg2);
    public final static native String DPLGetOptionalContentGroupName(int jarg1, int jarg2);
    public final static native String DPLGetOptionalContentGroupNameA(int jarg1, int jarg2);
    public final static native int DPLGetOptionalContentGroupPrintable(int jarg1, int jarg2);
    public final static native int DPLGetOptionalContentGroupVisible(int jarg1, int jarg2);
    public final static native int DPLGetOrigin(int jarg1);
    public final static native int DPLGetOutlineActionID(int jarg1, int jarg2);
    public final static native double DPLGetOutlineColor(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetOutlineDest(int jarg1, int jarg2);
    public final static native int DPLGetOutlineID(int jarg1, int jarg2);
    public final static native String DPLGetOutlineJavaScript(int jarg1, int jarg2);
    public final static native String DPLGetOutlineJavaScriptA(int jarg1, int jarg2);
    public final static native int DPLGetOutlineObjectNumber(int jarg1, int jarg2);
    public final static native String DPLGetOutlineOpenFile(int jarg1, int jarg2);
    public final static native String DPLGetOutlineOpenFileA(int jarg1, int jarg2);
    public final static native int DPLGetOutlinePage(int jarg1, int jarg2);
    public final static native int DPLGetOutlineStyle(int jarg1, int jarg2);
    public final static native String DPLGetOutlineWebLink(int jarg1, int jarg2);
    public final static native String DPLGetOutlineWebLinkA(int jarg1, int jarg2);
    public final static native double DPLGetPDF417SymbolHeight(int jarg1, String jarg2, int jarg3, int jarg4, int jarg5, int jarg6, double jarg7, double jarg8);
    public final static native double DPLGetPDF417SymbolHeightA(int jarg1, String jarg2, int jarg3, int jarg4, int jarg5, int jarg6, double jarg7, double jarg8);
    public final static native double DPLGetPDF417SymbolWidth(int jarg1, String jarg2, int jarg3, int jarg4, int jarg5, int jarg6, double jarg7, double jarg8);
    public final static native double DPLGetPDF417SymbolWidthA(int jarg1, String jarg2, int jarg3, int jarg4, int jarg5, int jarg6, double jarg7, double jarg8);
    public final static native double DPLGetPageBox(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetPageColorSpaces(int jarg1, int jarg2);
    public final static native String DPLGetPageColorSpacesA(int jarg1, int jarg2);
    public final static native byte[] DPLGetPageContentToString(int jarg1);
    public final static native int DPLGetPageImageList(int jarg1, int jarg2);
    public final static native String DPLGetPageJavaScript(int jarg1, String jarg2);
    public final static native String DPLGetPageJavaScriptA(int jarg1, String jarg2);
    public final static native String DPLGetPageLGIDictContent(int jarg1, int jarg2);
    public final static native String DPLGetPageLGIDictContentA(int jarg1, int jarg2);
    public final static native int DPLGetPageLGIDictCount(int jarg1);
    public final static native String DPLGetPageLabel(int jarg1, int jarg2);
    public final static native String DPLGetPageLabelA(int jarg1, int jarg2);
    public final static native int DPLGetPageLayout(int jarg1);
    public final static native byte[] DPLGetPageMetricsToString(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLGetPageMode(int jarg1);
    public final static native String DPLGetPageText(int jarg1, int jarg2);
    public final static native String DPLGetPageTextA(int jarg1, int jarg2);
    public final static native double DPLGetPageUserUnit(int jarg1);
    public final static native int DPLGetPageViewPortCount(int jarg1);
    public final static native int DPLGetPageViewPortID(int jarg1, int jarg2);
    public final static native int DPLGetParentOutline(int jarg1, int jarg2);
    public final static native int DPLGetPrevOutline(int jarg1, int jarg2);
    public final static native byte[] DPLGetPrintPreviewBitmapToString(int jarg1, String jarg2, int jarg3, int jarg4, int jarg5, int jarg6);
    public final static native byte[] DPLGetPrintPreviewBitmapToStringA(int jarg1, String jarg2, int jarg3, int jarg4, int jarg5, int jarg6);
    public final static native double DPLGetRenderScale(int jarg1);
    public final static native double DPLGetScale(int jarg1);
    public final static native int DPLGetSignProcessByteRange(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetSignProcessResult(int jarg1, int jarg2);
    public final static native int DPLGetStringListCount(int jarg1, int jarg2);
    public final static native String DPLGetStringListItem(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetStringListItemA(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetTabOrderMode(int jarg1);
    public final static native String DPLGetTabOrderModeA(int jarg1);
    public final static native double DPLGetTableCellDblProperty(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5);
    public final static native int DPLGetTableCellIntProperty(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5);
    public final static native String DPLGetTableCellStrProperty(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5);
    public final static native String DPLGetTableCellStrPropertyA(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5);
    public final static native int DPLGetTableColumnCount(int jarg1, int jarg2);
    public final static native int DPLGetTableLastDrawnRow(int jarg1, int jarg2);
    public final static native int DPLGetTableRowCount(int jarg1, int jarg2);
    public final static native String DPLGetTempPath(int jarg1);
    public final static native String DPLGetTempPathA(int jarg1);
    public final static native double DPLGetTextAscent(int jarg1);
    public final static native String DPLGetTextBlockAsString(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetTextBlockAsStringA(int jarg1, int jarg2, int jarg3);
    public final static native double DPLGetTextBlockBound(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native double DPLGetTextBlockCharWidth(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native double DPLGetTextBlockColor(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLGetTextBlockColorType(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetTextBlockCount(int jarg1, int jarg2);
    public final static native String DPLGetTextBlockFontName(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetTextBlockFontNameA(int jarg1, int jarg2, int jarg3);
    public final static native double DPLGetTextBlockFontSize(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetTextBlockText(int jarg1, int jarg2, int jarg3);
    public final static native String DPLGetTextBlockTextA(int jarg1, int jarg2, int jarg3);
    public final static native double DPLGetTextBound(int jarg1, int jarg2);
    public final static native double DPLGetTextDescent(int jarg1);
    public final static native double DPLGetTextHeight(int jarg1);
    public final static native double DPLGetTextSize(int jarg1);
    public final static native double DPLGetTextWidth(int jarg1, String jarg2);
    public final static native double DPLGetTextWidthA(int jarg1, String jarg2);
    public final static native String DPLGetUnicodeCharactersFromEncoding(int jarg1, int jarg2);
    public final static native String DPLGetUnicodeCharactersFromEncodingA(int jarg1, int jarg2);
    public final static native double DPLGetViewPortBBox(int jarg1, int jarg2, int jarg3);
    public final static native int DPLGetViewPortMeasureDict(int jarg1, int jarg2);
    public final static native String DPLGetViewPortName(int jarg1, int jarg2);
    public final static native String DPLGetViewPortNameA(int jarg1, int jarg2);
    public final static native int DPLGetViewPortPtDataDict(int jarg1, int jarg2);
    public final static native int DPLGetViewerPreferences(int jarg1, int jarg2);
    public final static native String DPLGetWrappedText(int jarg1, double jarg2, String jarg3, String jarg4);
    public final static native String DPLGetWrappedTextA(int jarg1, double jarg2, String jarg3, String jarg4);
    public final static native String DPLGetWrappedTextBreakString(int jarg1, double jarg2, String jarg3, String jarg4);
    public final static native String DPLGetWrappedTextBreakStringA(int jarg1, double jarg2, String jarg3, String jarg4);
    public final static native double DPLGetWrappedTextHeight(int jarg1, double jarg2, String jarg3);
    public final static native double DPLGetWrappedTextHeightA(int jarg1, double jarg2, String jarg3);
    public final static native int DPLGetWrappedTextLineCount(int jarg1, double jarg2, String jarg3);
    public final static native int DPLGetWrappedTextLineCountA(int jarg1, double jarg2, String jarg3);
    public final static native int DPLGetXFAFormFieldCount(int jarg1);
    public final static native String DPLGetXFAFormFieldName(int jarg1, int jarg2);
    public final static native String DPLGetXFAFormFieldNameA(int jarg1, int jarg2);
    public final static native String DPLGetXFAFormFieldNames(int jarg1, String jarg2);
    public final static native String DPLGetXFAFormFieldNamesA(int jarg1, String jarg2);
    public final static native String DPLGetXFAFormFieldValue(int jarg1, String jarg2);
    public final static native String DPLGetXFAFormFieldValueA(int jarg1, String jarg2);
    public final static native byte[] DPLGetXFAToString(int jarg1, int jarg2);
    public final static native int DPLGlobalJavaScriptCount(int jarg1);
    public final static native String DPLGlobalJavaScriptPackageName(int jarg1, int jarg2);
    public final static native String DPLGlobalJavaScriptPackageNameA(int jarg1, int jarg2);
    public final static native int DPLHasFontResources(int jarg1);
    public final static native int DPLHasPageBox(int jarg1, int jarg2);
    public final static native int DPLHidePage(int jarg1);
    public final static native int DPLImageCount(int jarg1);
    public final static native int DPLImageFillColor(int jarg1);
    public final static native int DPLImageHeight(int jarg1);
    public final static native int DPLImageHorizontalResolution(int jarg1);
    public final static native int DPLImageResolutionUnits(int jarg1);
    public final static native int DPLImageType(int jarg1);
    public final static native int DPLImageVerticalResolution(int jarg1);
    public final static native int DPLImageWidth(int jarg1);
    public final static native int DPLImportEMFFromFile(int jarg1, String jarg2, int jarg3, int jarg4);
    public final static native int DPLImportEMFFromFileA(int jarg1, String jarg2, int jarg3, int jarg4);
    public final static native int DPLInsertPages(int jarg1, int jarg2, int jarg3);
    public final static native int DPLInsertTableColumns(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLInsertTableRows(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLIsAnnotFormField(int jarg1, int jarg2);
    public final static native int DPLIsLinearized(int jarg1);
    public final static native int DPLIsTaggedPDF(int jarg1);
    public final static native int DPLLastErrorCode(int jarg1);
    public final static native String DPLLastRenderError(int jarg1);
    public final static native String DPLLastRenderErrorA(int jarg1);
    public final static native String DPLLibraryVersion(int jarg1);
    public final static native String DPLLibraryVersionA(int jarg1);
    public final static native String DPLLibraryVersionEx(int jarg1);
    public final static native String DPLLibraryVersionExA(int jarg1);
    public final static native String DPLLicenseInfo(int jarg1);
    public final static native String DPLLicenseInfoA(int jarg1);
    public final static native int DPLLinearizeFile(int jarg1, String jarg2, String jarg3, String jarg4, int jarg5);
    public final static native int DPLLinearizeFileA(int jarg1, String jarg2, String jarg3, String jarg4, int jarg5);
    public final static native int DPLLoadFromFile(int jarg1, String jarg2, String jarg3);
    public final static native int DPLLoadFromFileA(int jarg1, String jarg2, String jarg3);
    public final static native int DPLLoadFromString(int jarg1, byte[] jarg2, String jarg3);
    public final static native int DPLLoadFromStringA(int jarg1, byte[] jarg2, String jarg3);
    public final static native int DPLLoadState(int jarg1);
    public final static native int DPLMergeDocument(int jarg1, int jarg2);
    public final static native int DPLMergeFileList(int jarg1, String jarg2, String jarg3);
    public final static native int DPLMergeFileListA(int jarg1, String jarg2, String jarg3);
    public final static native int DPLMergeFileListFast(int jarg1, String jarg2, String jarg3);
    public final static native int DPLMergeFileListFastA(int jarg1, String jarg2, String jarg3);
    public final static native int DPLMergeFiles(int jarg1, String jarg2, String jarg3, String jarg4);
    public final static native int DPLMergeFilesA(int jarg1, String jarg2, String jarg3, String jarg4);
    public final static native int DPLMergeTableCells(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5, int jarg6);
    public final static native int DPLMoveContentStream(int jarg1, int jarg2, int jarg3);
    public final static native int DPLMoveOutlineAfter(int jarg1, int jarg2, int jarg3);
    public final static native int DPLMoveOutlineBefore(int jarg1, int jarg2, int jarg3);
    public final static native int DPLMovePage(int jarg1, int jarg2);
    public final static native int DPLMovePath(int jarg1, double jarg2, double jarg3);
    public final static native int DPLMultiplyScale(int jarg1, double jarg2);
    public final static native int DPLNewCMYKAxialShader(int jarg1, String jarg2, double jarg3, double jarg4, double jarg5, double jarg6, double jarg7, double jarg8, double jarg9, double jarg10, double jarg11, double jarg12, double jarg13, double jarg14, int jarg15);
    public final static native int DPLNewCMYKAxialShaderA(int jarg1, String jarg2, double jarg3, double jarg4, double jarg5, double jarg6, double jarg7, double jarg8, double jarg9, double jarg10, double jarg11, double jarg12, double jarg13, double jarg14, int jarg15);
    public final static native int DPLNewChildFormField(int jarg1, int jarg2, String jarg3, int jarg4);
    public final static native int DPLNewChildFormFieldA(int jarg1, int jarg2, String jarg3, int jarg4);
    public final static native int DPLNewContentStream(int jarg1);
    public final static native int DPLNewDestination(int jarg1, int jarg2, int jarg3, int jarg4, double jarg5, double jarg6, double jarg7, double jarg8);
    public final static native int DPLNewDocument(int jarg1);
    public final static native int DPLNewFormField(int jarg1, String jarg2, int jarg3);
    public final static native int DPLNewFormFieldA(int jarg1, String jarg2, int jarg3);
    public final static native int DPLNewNamedDestination(int jarg1, String jarg2, int jarg3);
    public final static native int DPLNewNamedDestinationA(int jarg1, String jarg2, int jarg3);
    public final static native int DPLNewOptionalContentGroup(int jarg1, String jarg2);
    public final static native int DPLNewOptionalContentGroupA(int jarg1, String jarg2);
    public final static native int DPLNewOutline(int jarg1, int jarg2, String jarg3, int jarg4, double jarg5);
    public final static native int DPLNewOutlineA(int jarg1, int jarg2, String jarg3, int jarg4, double jarg5);
    public final static native int DPLNewPage(int jarg1);
    public final static native int DPLNewPages(int jarg1, int jarg2);
    public final static native int DPLNewPostScriptXObject(int jarg1, String jarg2);
    public final static native int DPLNewPostScriptXObjectA(int jarg1, String jarg2);
    public final static native int DPLNewRGBAxialShader(int jarg1, String jarg2, double jarg3, double jarg4, double jarg5, double jarg6, double jarg7, double jarg8, double jarg9, double jarg10, double jarg11, double jarg12, int jarg13);
    public final static native int DPLNewRGBAxialShaderA(int jarg1, String jarg2, double jarg3, double jarg4, double jarg5, double jarg6, double jarg7, double jarg8, double jarg9, double jarg10, double jarg11, double jarg12, int jarg13);
    public final static native int DPLNewSignProcessFromFile(int jarg1, String jarg2, String jarg3);
    public final static native int DPLNewSignProcessFromFileA(int jarg1, String jarg2, String jarg3);
    public final static native int DPLNewSignProcessFromString(int jarg1, byte[] jarg2, String jarg3);
    public final static native int DPLNewSignProcessFromStringA(int jarg1, byte[] jarg2, String jarg3);
    public final static native int DPLNewStaticOutline(int jarg1, int jarg2, String jarg3);
    public final static native int DPLNewStaticOutlineA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLNewTilingPatternFromCapturedPage(int jarg1, String jarg2, int jarg3);
    public final static native int DPLNewTilingPatternFromCapturedPageA(int jarg1, String jarg2, int jarg3);
    public final static native int DPLNoEmbedFontListAdd(int jarg1, String jarg2);
    public final static native int DPLNoEmbedFontListAddA(int jarg1, String jarg2);
    public final static native int DPLNoEmbedFontListCount(int jarg1);
    public final static native String DPLNoEmbedFontListGet(int jarg1, int jarg2);
    public final static native String DPLNoEmbedFontListGetA(int jarg1, int jarg2);
    public final static native int DPLNoEmbedFontListRemoveAll(int jarg1);
    public final static native int DPLNoEmbedFontListRemoveIndex(int jarg1, int jarg2);
    public final static native int DPLNoEmbedFontListRemoveName(int jarg1, String jarg2);
    public final static native int DPLNoEmbedFontListRemoveNameA(int jarg1, String jarg2);
    public final static native int DPLNormalizePage(int jarg1, int jarg2);
    public final static native int DPLOpenOutline(int jarg1, int jarg2);
    public final static native int DPLOptionalContentGroupCount(int jarg1);
    public final static native int DPLOutlineCount(int jarg1);
    public final static native String DPLOutlineTitle(int jarg1, int jarg2);
    public final static native String DPLOutlineTitleA(int jarg1, int jarg2);
    public final static native int DPLPageCount(int jarg1);
    public final static native int DPLPageHasFontResources(int jarg1, int jarg2);
    public final static native double DPLPageHeight(int jarg1);
    public final static native int DPLPageJavaScriptAction(int jarg1, String jarg2, String jarg3);
    public final static native int DPLPageJavaScriptActionA(int jarg1, String jarg2, String jarg3);
    public final static native int DPLPageRotation(int jarg1);
    public final static native double DPLPageWidth(int jarg1);
    public final static native int DPLReduceSize(int jarg1, int jarg2);
    public final static native int DPLReleaseImage(int jarg1, int jarg2);
    public final static native int DPLReleaseImageList(int jarg1, int jarg2);
    public final static native int DPLReleaseLibrary(int jarg1);
    public final static native int DPLReleaseSignProcess(int jarg1, int jarg2);
    public final static native int DPLReleaseStringList(int jarg1, int jarg2);
    public final static native int DPLReleaseTextBlocks(int jarg1, int jarg2);
    public final static native int DPLRemoveAppearanceStream(int jarg1, int jarg2);
    public final static native int DPLRemoveCustomInformation(int jarg1, String jarg2);
    public final static native int DPLRemoveCustomInformationA(int jarg1, String jarg2);
    public final static native int DPLRemoveDocument(int jarg1, int jarg2);
    public final static native int DPLRemoveEmbeddedFile(int jarg1, int jarg2);
    public final static native int DPLRemoveFormFieldBackgroundColor(int jarg1, int jarg2);
    public final static native int DPLRemoveFormFieldBorderColor(int jarg1, int jarg2);
    public final static native int DPLRemoveFormFieldChoiceSub(int jarg1, int jarg2, String jarg3);
    public final static native int DPLRemoveFormFieldChoiceSubA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLRemoveGlobalJavaScript(int jarg1, String jarg2);
    public final static native int DPLRemoveGlobalJavaScriptA(int jarg1, String jarg2);
    public final static native int DPLRemoveOpenAction(int jarg1);
    public final static native int DPLRemoveOutline(int jarg1, int jarg2);
    public final static native int DPLRemovePageBox(int jarg1, int jarg2);
    public final static native int DPLRemoveSharedContentStreams(int jarg1);
    public final static native int DPLRemoveStyle(int jarg1, String jarg2);
    public final static native int DPLRemoveStyleA(int jarg1, String jarg2);
    public final static native int DPLRemoveUsageRights(int jarg1);
    public final static native int DPLRemoveXFAEntries(int jarg1, int jarg2);
    public final static native int DPLRenderAsMultipageTIFFToFile(int jarg1, double jarg2, String jarg3, int jarg4, int jarg5, String jarg6);
    public final static native int DPLRenderAsMultipageTIFFToFileA(int jarg1, double jarg2, String jarg3, int jarg4, int jarg5, String jarg6);
    public final static native int DPLRenderDocumentToFile(int jarg1, double jarg2, int jarg3, int jarg4, int jarg5, String jarg6);
    public final static native int DPLRenderDocumentToFileA(int jarg1, double jarg2, int jarg3, int jarg4, int jarg5, String jarg6);
    public final static native int DPLRenderPageToFile(int jarg1, double jarg2, int jarg3, int jarg4, String jarg5);
    public final static native int DPLRenderPageToFileA(int jarg1, double jarg2, int jarg3, int jarg4, String jarg5);
    public final static native byte[] DPLRenderPageToString(int jarg1, double jarg2, int jarg3, int jarg4);
    public final static native int DPLReplaceFonts(int jarg1, int jarg2);
    public final static native int DPLReplaceImage(int jarg1, int jarg2, int jarg3);
    public final static native int DPLReplaceTag(int jarg1, String jarg2, String jarg3);
    public final static native int DPLReplaceTagA(int jarg1, String jarg2, String jarg3);
    public final static native int DPLRetrieveCustomDataToFile(int jarg1, String jarg2, String jarg3, int jarg4);
    public final static native int DPLRetrieveCustomDataToFileA(int jarg1, String jarg2, String jarg3, int jarg4);
    public final static native byte[] DPLRetrieveCustomDataToString(int jarg1, String jarg2, int jarg3);
    public final static native byte[] DPLRetrieveCustomDataToStringA(int jarg1, String jarg2, int jarg3);
    public final static native int DPLReverseImage(int jarg1, int jarg2);
    public final static native int DPLRotatePage(int jarg1, int jarg2);
    public final static native int DPLSaveFontToFile(int jarg1, String jarg2);
    public final static native int DPLSaveFontToFileA(int jarg1, String jarg2);
    public final static native int DPLSaveImageListItemDataToFile(int jarg1, int jarg2, int jarg3, int jarg4, String jarg5);
    public final static native int DPLSaveImageListItemDataToFileA(int jarg1, int jarg2, int jarg3, int jarg4, String jarg5);
    public final static native int DPLSaveImageToFile(int jarg1, String jarg2);
    public final static native int DPLSaveImageToFileA(int jarg1, String jarg2);
    public final static native byte[] DPLSaveImageToString(int jarg1);
    public final static native int DPLSaveState(int jarg1);
    public final static native int DPLSaveStyle(int jarg1, String jarg2);
    public final static native int DPLSaveStyleA(int jarg1, String jarg2);
    public final static native int DPLSaveToFile(int jarg1, String jarg2);
    public final static native int DPLSaveToFileA(int jarg1, String jarg2);
    public final static native byte[] DPLSaveToString(int jarg1);
    public final static native int DPLSecurityInfo(int jarg1, int jarg2);
    public final static native int DPLSelectContentStream(int jarg1, int jarg2);
    public final static native int DPLSelectDocument(int jarg1, int jarg2);
    public final static native int DPLSelectFont(int jarg1, int jarg2);
    public final static native int DPLSelectImage(int jarg1, int jarg2);
    public final static native int DPLSelectPage(int jarg1, int jarg2);
    public final static native int DPLSelectedDocument(int jarg1);
    public final static native int DPLSelectedFont(int jarg1);
    public final static native int DPLSelectedImage(int jarg1);
    public final static native int DPLSelectedPage(int jarg1);
    public final static native int DPLSetActionURL(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetActionURLA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetAnnotBorderColor(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLSetAnnotBorderStyle(int jarg1, int jarg2, double jarg3, int jarg4, double jarg5, double jarg6);
    public final static native int DPLSetAnnotContents(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetAnnotContentsA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetAnnotDblProperty(int jarg1, int jarg2, int jarg3, double jarg4);
    public final static native int DPLSetAnnotIntProperty(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLSetAnnotOptional(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetAnnotQuadPoints(int jarg1, int jarg2, int jarg3, double jarg4, double jarg5, double jarg6, double jarg7, double jarg8, double jarg9, double jarg10, double jarg11);
    public final static native int DPLSetAnnotRect(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5, double jarg6);
    public final static native int DPLSetAnnotStrProperty(int jarg1, int jarg2, int jarg3, String jarg4);
    public final static native int DPLSetAnnotStrPropertyA(int jarg1, int jarg2, int jarg3, String jarg4);
    public final static native int DPLSetAnsiMode(int jarg1, int jarg2);
    public final static native int DPLSetAppendInputFromString(int jarg1, byte[] jarg2);
    public final static native int DPLSetBaseURL(int jarg1, String jarg2);
    public final static native int DPLSetBaseURLA(int jarg1, String jarg2);
    public final static native int DPLSetBlendMode(int jarg1, int jarg2);
    public final static native int DPLSetBreakString(int jarg1, String jarg2);
    public final static native int DPLSetBreakStringA(int jarg1, String jarg2);
    public final static native int DPLSetCSDictEPSG(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetCSDictType(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetCSDictWKT(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetCSDictWKTA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetCapturedPageOptional(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetCapturedPageTransparencyGroup(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5);
    public final static native int DPLSetCatalogInformation(int jarg1, String jarg2, String jarg3);
    public final static native int DPLSetCatalogInformationA(int jarg1, String jarg2, String jarg3);
    public final static native int DPLSetCharWidth(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetClippingPath(int jarg1);
    public final static native int DPLSetClippingPathEvenOdd(int jarg1);
    public final static native int DPLSetCompatibility(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetContentStreamFromString(int jarg1, byte[] jarg2);
    public final static native int DPLSetContentStreamOptional(int jarg1, int jarg2);
    public final static native int DPLSetCropBox(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLSetCustomInformation(int jarg1, String jarg2, String jarg3);
    public final static native int DPLSetCustomInformationA(int jarg1, String jarg2, String jarg3);
    public final static native int DPLSetCustomLineDash(int jarg1, String jarg2, double jarg3);
    public final static native int DPLSetCustomLineDashA(int jarg1, String jarg2, double jarg3);
    public final static native int DPLSetDestProperties(int jarg1, int jarg2, int jarg3, int jarg4, double jarg5, double jarg6, double jarg7, double jarg8);
    public final static native int DPLSetDestValue(int jarg1, int jarg2, int jarg3, double jarg4);
    public final static native int DPLSetDocumentMetadata(int jarg1, String jarg2);
    public final static native int DPLSetDocumentMetadataA(int jarg1, String jarg2);
    public final static native int DPLSetEmbeddedFileStrProperty(int jarg1, int jarg2, int jarg3, String jarg4);
    public final static native int DPLSetEmbeddedFileStrPropertyA(int jarg1, int jarg2, int jarg3, String jarg4);
    public final static native int DPLSetFillColor(int jarg1, double jarg2, double jarg3, double jarg4);
    public final static native int DPLSetFillColorCMYK(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLSetFillColorSep(int jarg1, String jarg2, double jarg3);
    public final static native int DPLSetFillColorSepA(int jarg1, String jarg2, double jarg3);
    public final static native int DPLSetFillShader(int jarg1, String jarg2);
    public final static native int DPLSetFillShaderA(int jarg1, String jarg2);
    public final static native int DPLSetFillTilingPattern(int jarg1, String jarg2);
    public final static native int DPLSetFillTilingPatternA(int jarg1, String jarg2);
    public final static native int DPLSetFindImagesMode(int jarg1, int jarg2);
    public final static native int DPLSetFontEncoding(int jarg1, int jarg2);
    public final static native int DPLSetFontFlags(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5, int jarg6, int jarg7, int jarg8, int jarg9);
    public final static native int DPLSetFormFieldAlignment(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetFormFieldAnnotFlags(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetFormFieldAppearanceFromString(int jarg1, int jarg2, byte[] jarg3, int jarg4, String jarg5);
    public final static native int DPLSetFormFieldAppearanceFromStringA(int jarg1, int jarg2, byte[] jarg3, int jarg4, String jarg5);
    public final static native int DPLSetFormFieldBackgroundColor(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLSetFormFieldBackgroundColorCMYK(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5, double jarg6);
    public final static native int DPLSetFormFieldBackgroundColorGray(int jarg1, int jarg2, double jarg3);
    public final static native int DPLSetFormFieldBackgroundColorSep(int jarg1, int jarg2, String jarg3, double jarg4);
    public final static native int DPLSetFormFieldBackgroundColorSepA(int jarg1, int jarg2, String jarg3, double jarg4);
    public final static native int DPLSetFormFieldBorderColor(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLSetFormFieldBorderColorCMYK(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5, double jarg6);
    public final static native int DPLSetFormFieldBorderColorGray(int jarg1, int jarg2, double jarg3);
    public final static native int DPLSetFormFieldBorderColorSep(int jarg1, int jarg2, String jarg3, double jarg4);
    public final static native int DPLSetFormFieldBorderColorSepA(int jarg1, int jarg2, String jarg3, double jarg4);
    public final static native int DPLSetFormFieldBorderStyle(int jarg1, int jarg2, double jarg3, int jarg4, double jarg5, double jarg6);
    public final static native int DPLSetFormFieldBounds(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5, double jarg6);
    public final static native int DPLSetFormFieldCalcOrder(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetFormFieldCaption(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetFormFieldCaptionA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetFormFieldCheckStyle(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLSetFormFieldChildTitle(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetFormFieldChildTitleA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetFormFieldChoiceSub(int jarg1, int jarg2, int jarg3, String jarg4, String jarg5);
    public final static native int DPLSetFormFieldChoiceSubA(int jarg1, int jarg2, int jarg3, String jarg4, String jarg5);
    public final static native int DPLSetFormFieldChoiceType(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetFormFieldColor(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLSetFormFieldColorCMYK(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5, double jarg6);
    public final static native int DPLSetFormFieldColorSep(int jarg1, int jarg2, String jarg3, double jarg4);
    public final static native int DPLSetFormFieldColorSepA(int jarg1, int jarg2, String jarg3, double jarg4);
    public final static native int DPLSetFormFieldComb(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetFormFieldCustomDict(int jarg1, int jarg2, String jarg3, String jarg4, int jarg5, int jarg6);
    public final static native int DPLSetFormFieldCustomDictA(int jarg1, int jarg2, String jarg3, String jarg4, int jarg5, int jarg6);
    public final static native int DPLSetFormFieldDefaultValue(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetFormFieldDefaultValueA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetFormFieldDefaultValueEx(int jarg1, int jarg2, String jarg3, int jarg4);
    public final static native int DPLSetFormFieldDefaultValueExA(int jarg1, int jarg2, String jarg3, int jarg4);
    public final static native int DPLSetFormFieldDescription(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetFormFieldDescriptionA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetFormFieldFlags(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetFormFieldFont(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetFormFieldFormatMode(int jarg1, int jarg2);
    public final static native int DPLSetFormFieldHighlightMode(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetFormFieldIcon(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLSetFormFieldIconStyle(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5, int jarg6, int jarg7);
    public final static native int DPLSetFormFieldLockAction(int jarg1, int jarg2, int jarg3, String jarg4, String jarg5);
    public final static native int DPLSetFormFieldLockActionA(int jarg1, int jarg2, int jarg3, String jarg4, String jarg5);
    public final static native int DPLSetFormFieldMaxLen(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetFormFieldMetadata(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetFormFieldMetadataA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetFormFieldNoExport(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetFormFieldOptional(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetFormFieldPage(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetFormFieldPrintable(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetFormFieldReadOnly(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetFormFieldRequired(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetFormFieldResetAction(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetFormFieldResetActionA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetFormFieldRichTextString(int jarg1, int jarg2, String jarg3, String jarg4);
    public final static native int DPLSetFormFieldRichTextStringA(int jarg1, int jarg2, String jarg3, String jarg4);
    public final static native int DPLSetFormFieldRotation(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetFormFieldSignatureImage(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLSetFormFieldStandardFont(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetFormFieldSubmitAction(int jarg1, int jarg2, String jarg3, String jarg4);
    public final static native int DPLSetFormFieldSubmitActionA(int jarg1, int jarg2, String jarg3, String jarg4);
    public final static native int DPLSetFormFieldSubmitActionEx(int jarg1, int jarg2, String jarg3, String jarg4, int jarg5);
    public final static native int DPLSetFormFieldSubmitActionExA(int jarg1, int jarg2, String jarg3, String jarg4, int jarg5);
    public final static native int DPLSetFormFieldTabOrder(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetFormFieldTextFlags(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5, int jarg6, int jarg7);
    public final static native int DPLSetFormFieldTextSize(int jarg1, int jarg2, double jarg3);
    public final static native int DPLSetFormFieldTitle(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetFormFieldTitleA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetFormFieldValue(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetFormFieldValueA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetFormFieldValueByTitle(int jarg1, String jarg2, String jarg3);
    public final static native int DPLSetFormFieldValueByTitleA(int jarg1, String jarg2, String jarg3);
    public final static native int DPLSetFormFieldValueEx(int jarg1, int jarg2, String jarg3, int jarg4);
    public final static native int DPLSetFormFieldValueExA(int jarg1, int jarg2, String jarg3, int jarg4);
    public final static native int DPLSetFormFieldVisible(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetHTMLBoldFont(int jarg1, String jarg2, int jarg3);
    public final static native int DPLSetHTMLBoldFontA(int jarg1, String jarg2, int jarg3);
    public final static native int DPLSetHTMLBoldItalicFont(int jarg1, String jarg2, int jarg3);
    public final static native int DPLSetHTMLBoldItalicFontA(int jarg1, String jarg2, int jarg3);
    public final static native int DPLSetHTMLItalicFont(int jarg1, String jarg2, int jarg3);
    public final static native int DPLSetHTMLItalicFontA(int jarg1, String jarg2, int jarg3);
    public final static native int DPLSetHTMLNormalFont(int jarg1, String jarg2, int jarg3);
    public final static native int DPLSetHTMLNormalFontA(int jarg1, String jarg2, int jarg3);
    public final static native int DPLSetHeaderCommentsFromString(int jarg1, byte[] jarg2);
    public final static native int DPLSetImageAsMask(int jarg1, int jarg2);
    public final static native int DPLSetImageMask(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, double jarg6, double jarg7);
    public final static native int DPLSetImageMaskCMYK(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5, double jarg6, double jarg7, double jarg8, double jarg9);
    public final static native int DPLSetImageMaskFromImage(int jarg1, int jarg2);
    public final static native int DPLSetImageOptional(int jarg1, int jarg2);
    public final static native int DPLSetImageResolution(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLSetInformation(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetInformationA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetJPEGQuality(int jarg1, int jarg2);
    public final static native int DPLSetJavaScriptMode(int jarg1, int jarg2);
    public final static native int DPLSetKerning(int jarg1, String jarg2, int jarg3);
    public final static native int DPLSetKerningA(int jarg1, String jarg2, int jarg3);
    public final static native int DPLSetLineCap(int jarg1, int jarg2);
    public final static native int DPLSetLineColor(int jarg1, double jarg2, double jarg3, double jarg4);
    public final static native int DPLSetLineColorCMYK(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLSetLineColorSep(int jarg1, String jarg2, double jarg3);
    public final static native int DPLSetLineColorSepA(int jarg1, String jarg2, double jarg3);
    public final static native int DPLSetLineDash(int jarg1, double jarg2, double jarg3);
    public final static native int DPLSetLineDashEx(int jarg1, String jarg2);
    public final static native int DPLSetLineDashExA(int jarg1, String jarg2);
    public final static native int DPLSetLineJoin(int jarg1, int jarg2);
    public final static native int DPLSetLineShader(int jarg1, String jarg2);
    public final static native int DPLSetLineShaderA(int jarg1, String jarg2);
    public final static native int DPLSetLineWidth(int jarg1, double jarg2);
    public final static native int DPLSetMarkupAnnotStyle(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5, double jarg6);
    public final static native int DPLSetMeasureDictBoundsCount(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetMeasureDictBoundsItem(int jarg1, int jarg2, int jarg3, double jarg4);
    public final static native int DPLSetMeasureDictCoordinateSystem(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetMeasureDictGPTSCount(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetMeasureDictGPTSItem(int jarg1, int jarg2, int jarg3, double jarg4);
    public final static native int DPLSetMeasureDictLPTSCount(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetMeasureDictLPTSItem(int jarg1, int jarg2, int jarg3, double jarg4);
    public final static native int DPLSetMeasureDictPDU(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5);
    public final static native int DPLSetMeasurementUnits(int jarg1, int jarg2);
    public final static native int DPLSetNeedAppearances(int jarg1, int jarg2);
    public final static native int DPLSetObjectFromString(int jarg1, int jarg2, byte[] jarg3);
    public final static native int DPLSetOpenActionDestination(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetOpenActionDestinationFull(int jarg1, int jarg2, int jarg3, int jarg4, double jarg5, double jarg6, double jarg7, double jarg8);
    public final static native int DPLSetOpenActionJavaScript(int jarg1, String jarg2);
    public final static native int DPLSetOpenActionJavaScriptA(int jarg1, String jarg2);
    public final static native int DPLSetOpenActionMenu(int jarg1, String jarg2);
    public final static native int DPLSetOpenActionMenuA(int jarg1, String jarg2);
    public final static native int DPLSetOptionalContentConfigLocked(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLSetOptionalContentConfigState(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLSetOptionalContentGroupName(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetOptionalContentGroupNameA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetOptionalContentGroupPrintable(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetOptionalContentGroupVisible(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetOrigin(int jarg1, int jarg2);
    public final static native int DPLSetOutlineColor(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLSetOutlineDestination(int jarg1, int jarg2, int jarg3, double jarg4);
    public final static native int DPLSetOutlineDestinationFull(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5, double jarg6, double jarg7, double jarg8, double jarg9);
    public final static native int DPLSetOutlineDestinationZoom(int jarg1, int jarg2, int jarg3, double jarg4, int jarg5);
    public final static native int DPLSetOutlineJavaScript(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetOutlineJavaScriptA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetOutlineNamedDestination(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetOutlineNamedDestinationA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetOutlineOpenFile(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetOutlineOpenFileA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetOutlineRemoteDestination(int jarg1, int jarg2, String jarg3, int jarg4, int jarg5, int jarg6, double jarg7, double jarg8, double jarg9, double jarg10, int jarg11);
    public final static native int DPLSetOutlineRemoteDestinationA(int jarg1, int jarg2, String jarg3, int jarg4, int jarg5, int jarg6, double jarg7, double jarg8, double jarg9, double jarg10, int jarg11);
    public final static native int DPLSetOutlineStyle(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLSetOutlineTitle(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetOutlineTitleA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetOutlineWebLink(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetOutlineWebLinkA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetOverprint(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLSetPDFAMode(int jarg1, int jarg2);
    public final static native int DPLSetPNGTransparencyColor(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLSetPageActionMenu(int jarg1, String jarg2);
    public final static native int DPLSetPageActionMenuA(int jarg1, String jarg2);
    public final static native int DPLSetPageBox(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5, double jarg6);
    public final static native int DPLSetPageContentFromString(int jarg1, byte[] jarg2);
    public final static native int DPLSetPageDimensions(int jarg1, double jarg2, double jarg3);
    public final static native int DPLSetPageLayout(int jarg1, int jarg2);
    public final static native int DPLSetPageMetadata(int jarg1, String jarg2);
    public final static native int DPLSetPageMetadataA(int jarg1, String jarg2);
    public final static native int DPLSetPageMode(int jarg1, int jarg2);
    public final static native int DPLSetPageSize(int jarg1, String jarg2);
    public final static native int DPLSetPageSizeA(int jarg1, String jarg2);
    public final static native int DPLSetPageThumbnail(int jarg1);
    public final static native int DPLSetPageTransparencyGroup(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLSetPageUserUnit(int jarg1, double jarg2);
    public final static native int DPLSetPrecision(int jarg1, int jarg2);
    public final static native int DPLSetRenderArea(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLSetRenderCropType(int jarg1, int jarg2);
    public final static native int DPLSetRenderOptions(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetRenderScale(int jarg1, double jarg2);
    public final static native int DPLSetScale(int jarg1, double jarg2);
    public final static native int DPLSetSignProcessAppearanceFromString(int jarg1, int jarg2, String jarg3, byte[] jarg4);
    public final static native int DPLSetSignProcessAppearanceFromStringA(int jarg1, int jarg2, String jarg3, byte[] jarg4);
    public final static native int DPLSetSignProcessCustomDict(int jarg1, int jarg2, String jarg3, String jarg4, int jarg5);
    public final static native int DPLSetSignProcessCustomDictA(int jarg1, int jarg2, String jarg3, String jarg4, int jarg5);
    public final static native int DPLSetSignProcessCustomSubFilter(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetSignProcessCustomSubFilterA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetSignProcessField(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetSignProcessFieldA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetSignProcessFieldBounds(int jarg1, int jarg2, double jarg3, double jarg4, double jarg5, double jarg6);
    public final static native int DPLSetSignProcessFieldImageFromFile(int jarg1, int jarg2, String jarg3, int jarg4);
    public final static native int DPLSetSignProcessFieldImageFromFileA(int jarg1, int jarg2, String jarg3, int jarg4);
    public final static native int DPLSetSignProcessFieldImageFromString(int jarg1, int jarg2, byte[] jarg3, int jarg4);
    public final static native int DPLSetSignProcessFieldLocked(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetSignProcessFieldMetadata(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetSignProcessFieldMetadataA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetSignProcessFieldPage(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetSignProcessImageLayer(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetSignProcessImageLayerA(int jarg1, int jarg2, String jarg3);
    public final static native int DPLSetSignProcessInfo(int jarg1, int jarg2, String jarg3, String jarg4, String jarg5);
    public final static native int DPLSetSignProcessInfoA(int jarg1, int jarg2, String jarg3, String jarg4, String jarg5);
    public final static native int DPLSetSignProcessKeyset(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetSignProcessOptions(int jarg1, int jarg2, int jarg3, int jarg4);
    public final static native int DPLSetSignProcessPFXFromFile(int jarg1, int jarg2, String jarg3, String jarg4);
    public final static native int DPLSetSignProcessPFXFromFileA(int jarg1, int jarg2, String jarg3, String jarg4);
    public final static native int DPLSetSignProcessPFXFromString(int jarg1, int jarg2, byte[] jarg3, String jarg4);
    public final static native int DPLSetSignProcessPFXFromStringA(int jarg1, int jarg2, byte[] jarg3, String jarg4);
    public final static native int DPLSetSignProcessPassthrough(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetSignProcessSubFilter(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetTabOrderMode(int jarg1, String jarg2);
    public final static native int DPLSetTabOrderModeA(int jarg1, String jarg2);
    public final static native int DPLSetTableBorderColor(int jarg1, int jarg2, int jarg3, double jarg4, double jarg5, double jarg6);
    public final static native int DPLSetTableBorderColorCMYK(int jarg1, int jarg2, int jarg3, double jarg4, double jarg5, double jarg6, double jarg7);
    public final static native int DPLSetTableBorderWidth(int jarg1, int jarg2, int jarg3, double jarg4);
    public final static native int DPLSetTableCellAlignment(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5, int jarg6, int jarg7);
    public final static native int DPLSetTableCellBackgroundColor(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5, int jarg6, double jarg7, double jarg8, double jarg9);
    public final static native int DPLSetTableCellBackgroundColorCMYK(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5, int jarg6, double jarg7, double jarg8, double jarg9, double jarg10);
    public final static native int DPLSetTableCellBorderColor(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5, int jarg6, int jarg7, double jarg8, double jarg9, double jarg10);
    public final static native int DPLSetTableCellBorderColorCMYK(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5, int jarg6, int jarg7, double jarg8, double jarg9, double jarg10, double jarg11);
    public final static native int DPLSetTableCellBorderWidth(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5, int jarg6, int jarg7, double jarg8);
    public final static native int DPLSetTableCellContent(int jarg1, int jarg2, int jarg3, int jarg4, String jarg5);
    public final static native int DPLSetTableCellContentA(int jarg1, int jarg2, int jarg3, int jarg4, String jarg5);
    public final static native int DPLSetTableCellPadding(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5, int jarg6, int jarg7, double jarg8);
    public final static native int DPLSetTableCellTextColor(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5, int jarg6, double jarg7, double jarg8, double jarg9);
    public final static native int DPLSetTableCellTextColorCMYK(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5, int jarg6, double jarg7, double jarg8, double jarg9, double jarg10);
    public final static native int DPLSetTableCellTextSize(int jarg1, int jarg2, int jarg3, int jarg4, int jarg5, int jarg6, double jarg7);
    public final static native int DPLSetTableColumnWidth(int jarg1, int jarg2, int jarg3, int jarg4, double jarg5);
    public final static native int DPLSetTableRowHeight(int jarg1, int jarg2, int jarg3, int jarg4, double jarg5);
    public final static native int DPLSetTableThinBorders(int jarg1, int jarg2, int jarg3, double jarg4, double jarg5, double jarg6);
    public final static native int DPLSetTableThinBordersCMYK(int jarg1, int jarg2, int jarg3, double jarg4, double jarg5, double jarg6, double jarg7);
    public final static native int DPLSetTempFile(int jarg1, String jarg2);
    public final static native int DPLSetTempFileA(int jarg1, String jarg2);
    public final static native int DPLSetTempPath(int jarg1, String jarg2);
    public final static native int DPLSetTempPathA(int jarg1, String jarg2);
    public final static native int DPLSetTextAlign(int jarg1, int jarg2);
    public final static native int DPLSetTextCharSpacing(int jarg1, double jarg2);
    public final static native int DPLSetTextColor(int jarg1, double jarg2, double jarg3, double jarg4);
    public final static native int DPLSetTextColorCMYK(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLSetTextColorSep(int jarg1, String jarg2, double jarg3);
    public final static native int DPLSetTextColorSepA(int jarg1, String jarg2, double jarg3);
    public final static native int DPLSetTextExtractionArea(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLSetTextExtractionOptions(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetTextExtractionScaling(int jarg1, int jarg2, double jarg3, double jarg4);
    public final static native int DPLSetTextExtractionWordGap(int jarg1, double jarg2);
    public final static native int DPLSetTextHighlight(int jarg1, int jarg2);
    public final static native int DPLSetTextHighlightColor(int jarg1, double jarg2, double jarg3, double jarg4);
    public final static native int DPLSetTextHighlightColorCMYK(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLSetTextHighlightColorSep(int jarg1, String jarg2, double jarg3);
    public final static native int DPLSetTextHighlightColorSepA(int jarg1, String jarg2, double jarg3);
    public final static native int DPLSetTextMode(int jarg1, int jarg2);
    public final static native int DPLSetTextRise(int jarg1, double jarg2);
    public final static native int DPLSetTextScaling(int jarg1, double jarg2);
    public final static native int DPLSetTextShader(int jarg1, String jarg2);
    public final static native int DPLSetTextShaderA(int jarg1, String jarg2);
    public final static native int DPLSetTextSize(int jarg1, double jarg2);
    public final static native int DPLSetTextSpacing(int jarg1, double jarg2);
    public final static native int DPLSetTextUnderline(int jarg1, int jarg2);
    public final static native int DPLSetTextUnderlineColor(int jarg1, double jarg2, double jarg3, double jarg4);
    public final static native int DPLSetTextUnderlineColorCMYK(int jarg1, double jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLSetTextUnderlineColorSep(int jarg1, String jarg2, double jarg3);
    public final static native int DPLSetTextUnderlineColorSepA(int jarg1, String jarg2, double jarg3);
    public final static native int DPLSetTextUnderlineCustomDash(int jarg1, String jarg2, double jarg3);
    public final static native int DPLSetTextUnderlineCustomDashA(int jarg1, String jarg2, double jarg3);
    public final static native int DPLSetTextUnderlineDash(int jarg1, double jarg2, double jarg3);
    public final static native int DPLSetTextUnderlineDistance(int jarg1, double jarg2);
    public final static native int DPLSetTextUnderlineWidth(int jarg1, double jarg2);
    public final static native int DPLSetTextWordSpacing(int jarg1, double jarg2);
    public final static native int DPLSetTransparency(int jarg1, int jarg2);
    public final static native int DPLSetUpdateMode(int jarg1, int jarg2);
    public final static native int DPLSetViewerPreferences(int jarg1, int jarg2, int jarg3);
    public final static native int DPLSetXFAFormFieldAccess(int jarg1, String jarg2, int jarg3);
    public final static native int DPLSetXFAFormFieldAccessA(int jarg1, String jarg2, int jarg3);
    public final static native int DPLSetXFAFormFieldBorderColor(int jarg1, String jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLSetXFAFormFieldBorderColorA(int jarg1, String jarg2, double jarg3, double jarg4, double jarg5);
    public final static native int DPLSetXFAFormFieldBorderPresence(int jarg1, String jarg2, int jarg3);
    public final static native int DPLSetXFAFormFieldBorderPresenceA(int jarg1, String jarg2, int jarg3);
    public final static native int DPLSetXFAFormFieldBorderWidth(int jarg1, String jarg2, double jarg3);
    public final static native int DPLSetXFAFormFieldBorderWidthA(int jarg1, String jarg2, double jarg3);
    public final static native int DPLSetXFAFormFieldValue(int jarg1, String jarg2, String jarg3);
    public final static native int DPLSetXFAFormFieldValueA(int jarg1, String jarg2, String jarg3);
    public final static native int DPLSetXFAFromString(int jarg1, byte[] jarg2, int jarg3);
    public final static native int DPLSignFile(int jarg1, String jarg2, String jarg3, String jarg4, String jarg5, String jarg6, String jarg7, String jarg8, String jarg9, String jarg10);
    public final static native int DPLSignFileA(int jarg1, String jarg2, String jarg3, String jarg4, String jarg5, String jarg6, String jarg7, String jarg8, String jarg9, String jarg10);
    public final static native int DPLSplitPageText(int jarg1, int jarg2);
    public final static native int DPLStartPath(int jarg1, double jarg2, double jarg3);
    public final static native int DPLStoreCustomDataFromFile(int jarg1, String jarg2, String jarg3, int jarg4, int jarg5);
    public final static native int DPLStoreCustomDataFromFileA(int jarg1, String jarg2, String jarg3, int jarg4, int jarg5);
    public final static native int DPLStoreCustomDataFromString(int jarg1, String jarg2, byte[] jarg3, int jarg4, int jarg5);
    public final static native int DPLStoreCustomDataFromStringA(int jarg1, String jarg2, byte[] jarg3, int jarg4, int jarg5);
    public final static native int DPLTestTempPath(int jarg1);
    public final static native int DPLTransformFile(int jarg1, String jarg2, String jarg3, String jarg4, int jarg5, int jarg6);
    public final static native int DPLTransformFileA(int jarg1, String jarg2, String jarg3, String jarg4, int jarg5, int jarg6);
    public final static native int DPLUnlockKey(int jarg1, String jarg2);
    public final static native int DPLUnlockKeyA(int jarg1, String jarg2);
    public final static native int DPLUnlocked(int jarg1);
    public final static native int DPLUpdateAndFlattenFormField(int jarg1, int jarg2);
    public final static native int DPLUpdateAppearanceStream(int jarg1, int jarg2);
    public final static native int DPLUpdateTrueTypeSubsettedFont(int jarg1, String jarg2);
    public final static native int DPLUpdateTrueTypeSubsettedFontA(int jarg1, String jarg2);
    public final static native int DPLUseKerning(int jarg1, int jarg2);
    public final static native int DPLUseUnsafeContentStreams(int jarg1, int jarg2);

    public DebenuPDFLibraryCPAndroidJava1711() {
        InstanceID = DPLCreateLibrary();
        LibraryLoaded = InstanceID != 0;
        if (LibraryLoaded) {
            DPLSetAnsiMode(InstanceID, 1);  // Default to UTF-8 strings
        }
    }

    public int AddArcToPath(double CenterX, double CenterY, double TotalAngle) {
        if (LibraryLoaded) {
            return DPLAddArcToPath(InstanceID, CenterX, CenterY, TotalAngle);
        } else return 0;
    }

    public int AddBoxToPath(double Left, double Top, double Width, double Height) {
        if (LibraryLoaded) {
            return DPLAddBoxToPath(InstanceID, Left, Top, Width, Height);
        } else return 0;
    }

    public int AddCJKFont(int CJKFontID) {
        if (LibraryLoaded) {
            return DPLAddCJKFont(InstanceID, CJKFontID);
        } else return 0;
    }

    public int AddCurveToPath(double CtAX, double CtAY, double CtBX, double CtBY, double EndX, double EndY) {
        if (LibraryLoaded) {
            return DPLAddCurveToPath(InstanceID, CtAX, CtAY, CtBX, CtBY, EndX, EndY);
        } else return 0;
    }

    public int AddEmbeddedFile(String FileName, String MIMEType) {
        if (LibraryLoaded) {
            return DPLAddEmbeddedFileA(InstanceID, FileName, MIMEType);
        } else return 0;
    }

    public int AddFileAttachment(String Title, int EmbeddedFileID) {
        if (LibraryLoaded) {
            return DPLAddFileAttachmentA(InstanceID, Title, EmbeddedFileID);
        } else return 0;
    }

    public int AddFormFieldChoiceSub(int Index, String SubName, String DisplayName) {
        if (LibraryLoaded) {
            return DPLAddFormFieldChoiceSubA(InstanceID, Index, SubName, DisplayName);
        } else return 0;
    }

    public int AddFormFieldSub(int Index, String SubName) {
        if (LibraryLoaded) {
            return DPLAddFormFieldSubA(InstanceID, Index, SubName);
        } else return 0;
    }

    public int AddFormFont(int FontID) {
        if (LibraryLoaded) {
            return DPLAddFormFont(InstanceID, FontID);
        } else return 0;
    }

    public int AddFreeTextAnnotation(double Left, double Top, double Width, double Height, String Text, int Angle, int Options) {
        if (LibraryLoaded) {
            return DPLAddFreeTextAnnotationA(InstanceID, Left, Top, Width, Height, Text, Angle, Options);
        } else return 0;
    }

    public int AddFreeTextAnnotationEx(double Left, double Top, double Width, double Height, String Text, int Angle, int Options, int Transparency) {
        if (LibraryLoaded) {
            return DPLAddFreeTextAnnotationExA(InstanceID, Left, Top, Width, Height, Text, Angle, Options, Transparency);
        } else return 0;
    }

    public int AddGlobalJavaScript(String PackageName, String JavaScript) {
        if (LibraryLoaded) {
            return DPLAddGlobalJavaScriptA(InstanceID, PackageName, JavaScript);
        } else return 0;
    }

    public int AddImageFromFile(String FileName, int Options) {
        if (LibraryLoaded) {
            return DPLAddImageFromFileA(InstanceID, FileName, Options);
        } else return 0;
    }

    public int AddImageFromFileOffset(String FileName, int Offset, int DataLength, int Options) {
        if (LibraryLoaded) {
            return DPLAddImageFromFileOffsetA(InstanceID, FileName, Offset, DataLength, Options);
        } else return 0;
    }

    public int AddImageFromString(byte[] Source, int Options) {
        if (LibraryLoaded) {
            return DPLAddImageFromString(InstanceID, Source, Options);
        } else return 0;
    }

    public int AddLGIDictToPage(String DictContent) {
        if (LibraryLoaded) {
            return DPLAddLGIDictToPageA(InstanceID, DictContent);
        } else return 0;
    }

    public int AddLineToPath(double EndX, double EndY) {
        if (LibraryLoaded) {
            return DPLAddLineToPath(InstanceID, EndX, EndY);
        } else return 0;
    }

    public int AddLinkToDestination(double Left, double Top, double Width, double Height, int DestID, int Options) {
        if (LibraryLoaded) {
            return DPLAddLinkToDestination(InstanceID, Left, Top, Width, Height, DestID, Options);
        } else return 0;
    }

    public int AddLinkToEmbeddedFile(double Left, double Top, double Width, double Height, int EmbeddedFileID, String Title, String Contents, int IconType, int Transpareny) {
        if (LibraryLoaded) {
            return DPLAddLinkToEmbeddedFileA(InstanceID, Left, Top, Width, Height, EmbeddedFileID, Title, Contents, IconType, Transpareny);
        } else return 0;
    }

    public int AddLinkToFile(double Left, double Top, double Width, double Height, String FileName, int Page, double Position, int NewWindow, int Options) {
        if (LibraryLoaded) {
            return DPLAddLinkToFileA(InstanceID, Left, Top, Width, Height, FileName, Page, Position, NewWindow, Options);
        } else return 0;
    }

    public int AddLinkToFileDest(double Left, double Top, double Width, double Height, String FileName, String NamedDest, double Position, int NewWindow, int Options) {
        if (LibraryLoaded) {
            return DPLAddLinkToFileDestA(InstanceID, Left, Top, Width, Height, FileName, NamedDest, Position, NewWindow, Options);
        } else return 0;
    }

    public int AddLinkToFileEx(double Left, double Top, double Width, double Height, String FileName, int DestPage, int NewWindow, int Options, int Zoom, int DestType, double DestLeft, double DestTop, double DestRight, double DestBottom) {
        if (LibraryLoaded) {
            return DPLAddLinkToFileExA(InstanceID, Left, Top, Width, Height, FileName, DestPage, NewWindow, Options, Zoom, DestType, DestLeft, DestTop, DestRight, DestBottom);
        } else return 0;
    }

    public int AddLinkToJavaScript(double Left, double Top, double Width, double Height, String JavaScript, int Options) {
        if (LibraryLoaded) {
            return DPLAddLinkToJavaScriptA(InstanceID, Left, Top, Width, Height, JavaScript, Options);
        } else return 0;
    }

    public int AddLinkToLocalFile(double Left, double Top, double Width, double Height, String FileName, int Options) {
        if (LibraryLoaded) {
            return DPLAddLinkToLocalFileA(InstanceID, Left, Top, Width, Height, FileName, Options);
        } else return 0;
    }

    public int AddLinkToPage(double Left, double Top, double Width, double Height, int Page, double Position, int Options) {
        if (LibraryLoaded) {
            return DPLAddLinkToPage(InstanceID, Left, Top, Width, Height, Page, Position, Options);
        } else return 0;
    }

    public int AddLinkToWeb(double Left, double Top, double Width, double Height, String Link, int Options) {
        if (LibraryLoaded) {
            return DPLAddLinkToWebA(InstanceID, Left, Top, Width, Height, Link, Options);
        } else return 0;
    }

    public int AddNoteAnnotation(double Left, double Top, int AnnotType, double PopupLeft, double PopupTop, double PopupWidth, double PopupHeight, String Title, String Contents, double Red, double Green, double Blue, int Open) {
        if (LibraryLoaded) {
            return DPLAddNoteAnnotationA(InstanceID, Left, Top, AnnotType, PopupLeft, PopupTop, PopupWidth, PopupHeight, Title, Contents, Red, Green, Blue, Open);
        } else return 0;
    }

    public int AddOpenTypeFontFromFile(String FileName, int Options) {
        if (LibraryLoaded) {
            return DPLAddOpenTypeFontFromFileA(InstanceID, FileName, Options);
        } else return 0;
    }

    public int AddOpenTypeFontFromString(byte[] Source, int Options) {
        if (LibraryLoaded) {
            return DPLAddOpenTypeFontFromString(InstanceID, Source, Options);
        } else return 0;
    }

    public int AddPageLabels(int Start, int Style, int Offset, String Prefix) {
        if (LibraryLoaded) {
            return DPLAddPageLabelsA(InstanceID, Start, Style, Offset, Prefix);
        } else return 0;
    }

    public int AddPageMatrix(double xscale, double yscale, double xoffset, double yoffset) {
        if (LibraryLoaded) {
            return DPLAddPageMatrix(InstanceID, xscale, yscale, xoffset, yoffset);
        } else return 0;
    }

    public int AddRGBSeparationColor(String ColorName, double Red, double Green, double Blue, int Options) {
        if (LibraryLoaded) {
            return DPLAddRGBSeparationColorA(InstanceID, ColorName, Red, Green, Blue, Options);
        } else return 0;
    }

    public int AddRelativeLinkToFile(double Left, double Top, double Width, double Height, String FileName, int Page, double Position, int NewWindow, int Options) {
        if (LibraryLoaded) {
            return DPLAddRelativeLinkToFileA(InstanceID, Left, Top, Width, Height, FileName, Page, Position, NewWindow, Options);
        } else return 0;
    }

    public int AddRelativeLinkToFileDest(double Left, double Top, double Width, double Height, String FileName, String NamedDest, double Position, int NewWindow, int Options) {
        if (LibraryLoaded) {
            return DPLAddRelativeLinkToFileDestA(InstanceID, Left, Top, Width, Height, FileName, NamedDest, Position, NewWindow, Options);
        } else return 0;
    }

    public int AddRelativeLinkToFileEx(double Left, double Top, double Width, double Height, String FileName, int DestPage, int NewWindow, int Options, int Zoom, int DestType, double DestLeft, double DestTop, double DestRight, double DestBottom) {
        if (LibraryLoaded) {
            return DPLAddRelativeLinkToFileExA(InstanceID, Left, Top, Width, Height, FileName, DestPage, NewWindow, Options, Zoom, DestType, DestLeft, DestTop, DestRight, DestBottom);
        } else return 0;
    }

    public int AddRelativeLinkToLocalFile(double Left, double Top, double Width, double Height, String FileName, int Options) {
        if (LibraryLoaded) {
            return DPLAddRelativeLinkToLocalFileA(InstanceID, Left, Top, Width, Height, FileName, Options);
        } else return 0;
    }

    public int AddSVGAnnotationFromFile(double Left, double Top, double Width, double Height, String FileName, int Options) {
        if (LibraryLoaded) {
            return DPLAddSVGAnnotationFromFileA(InstanceID, Left, Top, Width, Height, FileName, Options);
        } else return 0;
    }

    public int AddSWFAnnotationFromFile(double Left, double Top, double Width, double Height, String FileName, String Title, int Options) {
        if (LibraryLoaded) {
            return DPLAddSWFAnnotationFromFileA(InstanceID, Left, Top, Width, Height, FileName, Title, Options);
        } else return 0;
    }

    public int AddSeparationColor(String ColorName, double C, double M, double Y, double K, int Options) {
        if (LibraryLoaded) {
            return DPLAddSeparationColorA(InstanceID, ColorName, C, M, Y, K, Options);
        } else return 0;
    }

    public int AddSignProcessOverlayText(int SignProcessID, double XPos, double YPos, double TextSize, String LayerName, String OverlayText) {
        if (LibraryLoaded) {
            return DPLAddSignProcessOverlayTextA(InstanceID, SignProcessID, XPos, YPos, TextSize, LayerName, OverlayText);
        } else return 0;
    }

    public int AddStampAnnotation(double Left, double Top, double Width, double Height, int StampType, String Title, String Contents, double Red, double Green, double Blue, int Options) {
        if (LibraryLoaded) {
            return DPLAddStampAnnotationA(InstanceID, Left, Top, Width, Height, StampType, Title, Contents, Red, Green, Blue, Options);
        } else return 0;
    }

    public int AddStampAnnotationFromImage(double Left, double Top, double Width, double Height, String FileName, String Title, String Contents, double Red, double Green, double Blue, int Options) {
        if (LibraryLoaded) {
            return DPLAddStampAnnotationFromImageA(InstanceID, Left, Top, Width, Height, FileName, Title, Contents, Red, Green, Blue, Options);
        } else return 0;
    }

    public int AddStampAnnotationFromImageID(double Left, double Top, double Width, double Height, int ImageID, String Title, String Contents, double Red, double Green, double Blue, int Options) {
        if (LibraryLoaded) {
            return DPLAddStampAnnotationFromImageIDA(InstanceID, Left, Top, Width, Height, ImageID, Title, Contents, Red, Green, Blue, Options);
        } else return 0;
    }

    public int AddStandardFont(int StandardFontID) {
        if (LibraryLoaded) {
            return DPLAddStandardFont(InstanceID, StandardFontID);
        } else return 0;
    }

    public int AddSubsettedFont(String FontName, int CharsetIndex, String SubsetChars) {
        if (LibraryLoaded) {
            return DPLAddSubsettedFontA(InstanceID, FontName, CharsetIndex, SubsetChars);
        } else return 0;
    }

    public int AddTextMarkupAnnotation(int MarkupType, double Left, double Top, double Width, double Height) {
        if (LibraryLoaded) {
            return DPLAddTextMarkupAnnotation(InstanceID, MarkupType, Left, Top, Width, Height);
        } else return 0;
    }

    public int AddToFileList(String ListName, String FileName) {
        if (LibraryLoaded) {
            return DPLAddToFileListA(InstanceID, ListName, FileName);
        } else return 0;
    }

    public int AddTrueTypeFont(String FontName, int Embed) {
        if (LibraryLoaded) {
            return DPLAddTrueTypeFontA(InstanceID, FontName, Embed);
        } else return 0;
    }

    public int AddTrueTypeFontFromFile(String FileName) {
        if (LibraryLoaded) {
            return DPLAddTrueTypeFontFromFileA(InstanceID, FileName);
        } else return 0;
    }

    public int AddTrueTypeFontFromString(byte[] Source) {
        if (LibraryLoaded) {
            return DPLAddTrueTypeFontFromString(InstanceID, Source);
        } else return 0;
    }

    public int AddTrueTypeFontFromStringEx(byte[] Source, int Options) {
        if (LibraryLoaded) {
            return DPLAddTrueTypeFontFromStringEx(InstanceID, Source, Options);
        } else return 0;
    }

    public int AddTrueTypeSubsettedFont(String FontName, String SubsetChars, int Options) {
        if (LibraryLoaded) {
            return DPLAddTrueTypeSubsettedFontA(InstanceID, FontName, SubsetChars, Options);
        } else return 0;
    }

    public int AddTrueTypeSubsettedFontFromFile(String FileName, String SubsetChars, int Options) {
        if (LibraryLoaded) {
            return DPLAddTrueTypeSubsettedFontFromFileA(InstanceID, FileName, SubsetChars, Options);
        } else return 0;
    }

    public int AddTrueTypeSubsettedFontFromString(byte[] Source, String SubsetChars, int Options) {
        if (LibraryLoaded) {
            return DPLAddTrueTypeSubsettedFontFromStringA(InstanceID, Source, SubsetChars, Options);
        } else return 0;
    }

    public int AddType1Font(String FileName) {
        if (LibraryLoaded) {
            return DPLAddType1FontA(InstanceID, FileName);
        } else return 0;
    }

    public int AddU3DAnnotationFromFile(double Left, double Top, double Width, double Height, String FileName, int Options) {
        if (LibraryLoaded) {
            return DPLAddU3DAnnotationFromFileA(InstanceID, Left, Top, Width, Height, FileName, Options);
        } else return 0;
    }

    public int AnalyseFile(String InputFileName, String Password) {
        if (LibraryLoaded) {
            return DPLAnalyseFileA(InstanceID, InputFileName, Password);
        } else return 0;
    }

    public int AnnotationCount() {
        if (LibraryLoaded) {
            return DPLAnnotationCount(InstanceID);
        } else return 0;
    }

    public int AppendSpace(double RelativeSpace) {
        if (LibraryLoaded) {
            return DPLAppendSpace(InstanceID, RelativeSpace);
        } else return 0;
    }

    public int AppendTableColumns(int TableID, int NewColumnCount) {
        if (LibraryLoaded) {
            return DPLAppendTableColumns(InstanceID, TableID, NewColumnCount);
        } else return 0;
    }

    public int AppendTableRows(int TableID, int NewRowCount) {
        if (LibraryLoaded) {
            return DPLAppendTableRows(InstanceID, TableID, NewRowCount);
        } else return 0;
    }

    public int AppendText(String Text) {
        if (LibraryLoaded) {
            return DPLAppendTextA(InstanceID, Text);
        } else return 0;
    }

    public int AppendToFile(String FileName) {
        if (LibraryLoaded) {
            return DPLAppendToFileA(InstanceID, FileName);
        } else return 0;
    }

    public byte[] AppendToString(int AppendMode) {
        if (LibraryLoaded) {
            return DPLAppendToString(InstanceID, AppendMode);
        } else return new byte[0];
    }

    public int ApplyStyle(String StyleName) {
        if (LibraryLoaded) {
            return DPLApplyStyleA(InstanceID, StyleName);
        } else return 0;
    }

    public int AttachAnnotToForm(int Index) {
        if (LibraryLoaded) {
            return DPLAttachAnnotToForm(InstanceID, Index);
        } else return 0;
    }

    public int BalanceContentStream() {
        if (LibraryLoaded) {
            return DPLBalanceContentStream(InstanceID);
        } else return 0;
    }

    public int BalancePageTree(int Options) {
        if (LibraryLoaded) {
            return DPLBalancePageTree(InstanceID, Options);
        } else return 0;
    }

    public int BeginPageUpdate() {
        if (LibraryLoaded) {
            return DPLBeginPageUpdate(InstanceID);
        } else return 0;
    }

    public int CapturePage(int Page) {
        if (LibraryLoaded) {
            return DPLCapturePage(InstanceID, Page);
        } else return 0;
    }

    public int CapturePageEx(int Page, int Options) {
        if (LibraryLoaded) {
            return DPLCapturePageEx(InstanceID, Page, Options);
        } else return 0;
    }

    public int CharWidth(int CharCode) {
        if (LibraryLoaded) {
            return DPLCharWidth(InstanceID, CharCode);
        } else return 0;
    }

    public int CheckFileCompliance(String InputFileName, String Password, int ComplianceTest, int Options) {
        if (LibraryLoaded) {
            return DPLCheckFileComplianceA(InstanceID, InputFileName, Password, ComplianceTest, Options);
        } else return 0;
    }

    public int CheckObjects() {
        if (LibraryLoaded) {
            return DPLCheckObjects(InstanceID);
        } else return 0;
    }

    public int CheckPageAnnots() {
        if (LibraryLoaded) {
            return DPLCheckPageAnnots(InstanceID);
        } else return 0;
    }

    public int CheckPassword(String Password) {
        if (LibraryLoaded) {
            return DPLCheckPasswordA(InstanceID, Password);
        } else return 0;
    }

    public int ClearFileList(String ListName) {
        if (LibraryLoaded) {
            return DPLClearFileListA(InstanceID, ListName);
        } else return 0;
    }

    public int ClearImage(int ImageID) {
        if (LibraryLoaded) {
            return DPLClearImage(InstanceID, ImageID);
        } else return 0;
    }

    public int ClearPageLabels() {
        if (LibraryLoaded) {
            return DPLClearPageLabels(InstanceID);
        } else return 0;
    }

    public int ClearTextFormatting() {
        if (LibraryLoaded) {
            return DPLClearTextFormatting(InstanceID);
        } else return 0;
    }

    public int CloneOutlineAction(int OutlineID) {
        if (LibraryLoaded) {
            return DPLCloneOutlineAction(InstanceID, OutlineID);
        } else return 0;
    }

    public int ClonePages(int StartPage, int EndPage, int RepeatCount) {
        if (LibraryLoaded) {
            return DPLClonePages(InstanceID, StartPage, EndPage, RepeatCount);
        } else return 0;
    }

    public int CloseOutline(int OutlineID) {
        if (LibraryLoaded) {
            return DPLCloseOutline(InstanceID, OutlineID);
        } else return 0;
    }

    public int ClosePath() {
        if (LibraryLoaded) {
            return DPLClosePath(InstanceID);
        } else return 0;
    }

    public int CombineContentStreams() {
        if (LibraryLoaded) {
            return DPLCombineContentStreams(InstanceID);
        } else return 0;
    }

    public int CompareOutlines(int FirstOutlineID, int SecondOutlineID) {
        if (LibraryLoaded) {
            return DPLCompareOutlines(InstanceID, FirstOutlineID, SecondOutlineID);
        } else return 0;
    }

    public int CompressContent() {
        if (LibraryLoaded) {
            return DPLCompressContent(InstanceID);
        } else return 0;
    }

    public int CompressFonts(int Compress) {
        if (LibraryLoaded) {
            return DPLCompressFonts(InstanceID, Compress);
        } else return 0;
    }

    public int CompressImages(int Compress) {
        if (LibraryLoaded) {
            return DPLCompressImages(InstanceID, Compress);
        } else return 0;
    }

    public int CompressPage() {
        if (LibraryLoaded) {
            return DPLCompressPage(InstanceID);
        } else return 0;
    }

    public int ContentStreamCount() {
        if (LibraryLoaded) {
            return DPLContentStreamCount(InstanceID);
        } else return 0;
    }

    public int ContentStreamSafe() {
        if (LibraryLoaded) {
            return DPLContentStreamSafe(InstanceID);
        } else return 0;
    }

    public int CopyPageRanges(int DocumentID, String RangeList) {
        if (LibraryLoaded) {
            return DPLCopyPageRangesA(InstanceID, DocumentID, RangeList);
        } else return 0;
    }

    public int CopyPageRangesEx(int DocumentID, String RangeList, int Options) {
        if (LibraryLoaded) {
            return DPLCopyPageRangesExA(InstanceID, DocumentID, RangeList, Options);
        } else return 0;
    }

    public int CreateNewObject() {
        if (LibraryLoaded) {
            return DPLCreateNewObject(InstanceID);
        } else return 0;
    }

    public int CreateTable(int RowCount, int ColumnCount) {
        if (LibraryLoaded) {
            return DPLCreateTable(InstanceID, RowCount, ColumnCount);
        } else return 0;
    }

    public int DAAppendFile(int FileHandle) {
        if (LibraryLoaded) {
            return DPLDAAppendFile(InstanceID, FileHandle);
        } else return 0;
    }

    public int DACapturePage(int FileHandle, int PageRef) {
        if (LibraryLoaded) {
            return DPLDACapturePage(InstanceID, FileHandle, PageRef);
        } else return 0;
    }

    public int DACapturePageEx(int FileHandle, int PageRef, int Options) {
        if (LibraryLoaded) {
            return DPLDACapturePageEx(InstanceID, FileHandle, PageRef, Options);
        } else return 0;
    }

    public int DACloseFile(int FileHandle) {
        if (LibraryLoaded) {
            return DPLDACloseFile(InstanceID, FileHandle);
        } else return 0;
    }

    public int DADrawCapturedPage(int FileHandle, int DACaptureID, int DestPageRef, double PntLeft, double PntBottom, double PntWidth, double PntHeight) {
        if (LibraryLoaded) {
            return DPLDADrawCapturedPage(InstanceID, FileHandle, DACaptureID, DestPageRef, PntLeft, PntBottom, PntWidth, PntHeight);
        } else return 0;
    }

    public int DADrawRotatedCapturedPage(int FileHandle, int DACaptureID, int DestPageRef, double PntLeft, double PntBottom, double PntWidth, double PntHeight, double Angle) {
        if (LibraryLoaded) {
            return DPLDADrawRotatedCapturedPage(InstanceID, FileHandle, DACaptureID, DestPageRef, PntLeft, PntBottom, PntWidth, PntHeight, Angle);
        } else return 0;
    }

    public int DAEmbedFileStreams(int FileHandle, String RootPath) {
        if (LibraryLoaded) {
            return DPLDAEmbedFileStreamsA(InstanceID, FileHandle, RootPath);
        } else return 0;
    }

    public String DAExtractPageText(int FileHandle, int PageRef, int Options) {
        if (LibraryLoaded) {
            return DPLDAExtractPageTextA(InstanceID, FileHandle, PageRef, Options);
        } else return "";
    }

    public int DAExtractPageTextBlocks(int FileHandle, int PageRef, int ExtractOptions) {
        if (LibraryLoaded) {
            return DPLDAExtractPageTextBlocks(InstanceID, FileHandle, PageRef, ExtractOptions);
        } else return 0;
    }

    public int DAFindPage(int FileHandle, int Page) {
        if (LibraryLoaded) {
            return DPLDAFindPage(InstanceID, FileHandle, Page);
        } else return 0;
    }

    public int DAGetAnnotationCount(int FileHandle, int PageRef) {
        if (LibraryLoaded) {
            return DPLDAGetAnnotationCount(InstanceID, FileHandle, PageRef);
        } else return 0;
    }

    public int DAGetFormFieldCount(int FileHandle) {
        if (LibraryLoaded) {
            return DPLDAGetFormFieldCount(InstanceID, FileHandle);
        } else return 0;
    }

    public String DAGetFormFieldTitle(int FileHandle, int FieldIndex) {
        if (LibraryLoaded) {
            return DPLDAGetFormFieldTitleA(InstanceID, FileHandle, FieldIndex);
        } else return "";
    }

    public String DAGetFormFieldValue(int FileHandle, int FieldIndex) {
        if (LibraryLoaded) {
            return DPLDAGetFormFieldValueA(InstanceID, FileHandle, FieldIndex);
        } else return "";
    }

    public byte[] DAGetImageDataToString(int FileHandle, int ImageListID, int ImageIndex) {
        if (LibraryLoaded) {
            return DPLDAGetImageDataToString(InstanceID, FileHandle, ImageListID, ImageIndex);
        } else return new byte[0];
    }

    public double DAGetImageDblProperty(int FileHandle, int ImageListID, int ImageIndex, int PropertyID) {
        if (LibraryLoaded) {
            return DPLDAGetImageDblProperty(InstanceID, FileHandle, ImageListID, ImageIndex, PropertyID);
        } else return 0;
    }

    public int DAGetImageIntProperty(int FileHandle, int ImageListID, int ImageIndex, int PropertyID) {
        if (LibraryLoaded) {
            return DPLDAGetImageIntProperty(InstanceID, FileHandle, ImageListID, ImageIndex, PropertyID);
        } else return 0;
    }

    public int DAGetImageListCount(int FileHandle, int ImageListID) {
        if (LibraryLoaded) {
            return DPLDAGetImageListCount(InstanceID, FileHandle, ImageListID);
        } else return 0;
    }

    public String DAGetInformation(int FileHandle, String Key) {
        if (LibraryLoaded) {
            return DPLDAGetInformationA(InstanceID, FileHandle, Key);
        } else return "";
    }

    public int DAGetObjectCount(int FileHandle) {
        if (LibraryLoaded) {
            return DPLDAGetObjectCount(InstanceID, FileHandle);
        } else return 0;
    }

    public byte[] DAGetObjectToString(int FileHandle, int ObjectNumber) {
        if (LibraryLoaded) {
            return DPLDAGetObjectToString(InstanceID, FileHandle, ObjectNumber);
        } else return new byte[0];
    }

    public double DAGetPageBox(int FileHandle, int PageRef, int BoxIndex, int Dimension) {
        if (LibraryLoaded) {
            return DPLDAGetPageBox(InstanceID, FileHandle, PageRef, BoxIndex, Dimension);
        } else return 0;
    }

    public byte[] DAGetPageContentToString(int FileHandle, int PageRef) {
        if (LibraryLoaded) {
            return DPLDAGetPageContentToString(InstanceID, FileHandle, PageRef);
        } else return new byte[0];
    }

    public int DAGetPageCount(int FileHandle) {
        if (LibraryLoaded) {
            return DPLDAGetPageCount(InstanceID, FileHandle);
        } else return 0;
    }

    public double DAGetPageHeight(int FileHandle, int PageRef) {
        if (LibraryLoaded) {
            return DPLDAGetPageHeight(InstanceID, FileHandle, PageRef);
        } else return 0;
    }

    public int DAGetPageImageList(int FileHandle, int PageRef) {
        if (LibraryLoaded) {
            return DPLDAGetPageImageList(InstanceID, FileHandle, PageRef);
        } else return 0;
    }

    public int DAGetPageLayout(int FileHandle) {
        if (LibraryLoaded) {
            return DPLDAGetPageLayout(InstanceID, FileHandle);
        } else return 0;
    }

    public int DAGetPageMode(int FileHandle) {
        if (LibraryLoaded) {
            return DPLDAGetPageMode(InstanceID, FileHandle);
        } else return 0;
    }

    public double DAGetPageWidth(int FileHandle, int PageRef) {
        if (LibraryLoaded) {
            return DPLDAGetPageWidth(InstanceID, FileHandle, PageRef);
        } else return 0;
    }

    public String DAGetTextBlockAsString(int TextBlockListID, int Index) {
        if (LibraryLoaded) {
            return DPLDAGetTextBlockAsStringA(InstanceID, TextBlockListID, Index);
        } else return "";
    }

    public double DAGetTextBlockBound(int TextBlockListID, int Index, int BoundIndex) {
        if (LibraryLoaded) {
            return DPLDAGetTextBlockBound(InstanceID, TextBlockListID, Index, BoundIndex);
        } else return 0;
    }

    public double DAGetTextBlockCharWidth(int TextBlockListID, int Index, int CharIndex) {
        if (LibraryLoaded) {
            return DPLDAGetTextBlockCharWidth(InstanceID, TextBlockListID, Index, CharIndex);
        } else return 0;
    }

    public double DAGetTextBlockColor(int TextBlockListID, int Index, int ColorComponent) {
        if (LibraryLoaded) {
            return DPLDAGetTextBlockColor(InstanceID, TextBlockListID, Index, ColorComponent);
        } else return 0;
    }

    public int DAGetTextBlockColorType(int TextBlockListID, int Index) {
        if (LibraryLoaded) {
            return DPLDAGetTextBlockColorType(InstanceID, TextBlockListID, Index);
        } else return 0;
    }

    public int DAGetTextBlockCount(int TextBlockListID) {
        if (LibraryLoaded) {
            return DPLDAGetTextBlockCount(InstanceID, TextBlockListID);
        } else return 0;
    }

    public String DAGetTextBlockFontName(int TextBlockListID, int Index) {
        if (LibraryLoaded) {
            return DPLDAGetTextBlockFontNameA(InstanceID, TextBlockListID, Index);
        } else return "";
    }

    public double DAGetTextBlockFontSize(int TextBlockListID, int Index) {
        if (LibraryLoaded) {
            return DPLDAGetTextBlockFontSize(InstanceID, TextBlockListID, Index);
        } else return 0;
    }

    public String DAGetTextBlockText(int TextBlockListID, int Index) {
        if (LibraryLoaded) {
            return DPLDAGetTextBlockTextA(InstanceID, TextBlockListID, Index);
        } else return "";
    }

    public int DAHasPageBox(int FileHandle, int PageRef, int BoxIndex) {
        if (LibraryLoaded) {
            return DPLDAHasPageBox(InstanceID, FileHandle, PageRef, BoxIndex);
        } else return 0;
    }

    public int DAHidePage(int FileHandle, int PageRef) {
        if (LibraryLoaded) {
            return DPLDAHidePage(InstanceID, FileHandle, PageRef);
        } else return 0;
    }

    public int DAMovePage(int FileHandle, int PageRef, int TargetPageRef, int Options) {
        if (LibraryLoaded) {
            return DPLDAMovePage(InstanceID, FileHandle, PageRef, TargetPageRef, Options);
        } else return 0;
    }

    public int DANewPage(int FileHandle) {
        if (LibraryLoaded) {
            return DPLDANewPage(InstanceID, FileHandle);
        } else return 0;
    }

    public int DANewPages(int FileHandle, int PageCount) {
        if (LibraryLoaded) {
            return DPLDANewPages(InstanceID, FileHandle, PageCount);
        } else return 0;
    }

    public int DANormalizePage(int FileHandle, int PageRef, int NormalizeOptions) {
        if (LibraryLoaded) {
            return DPLDANormalizePage(InstanceID, FileHandle, PageRef, NormalizeOptions);
        } else return 0;
    }

    public int DAOpenFile(String InputFileName, String Password) {
        if (LibraryLoaded) {
            return DPLDAOpenFileA(InstanceID, InputFileName, Password);
        } else return 0;
    }

    public int DAOpenFileReadOnly(String InputFileName, String Password) {
        if (LibraryLoaded) {
            return DPLDAOpenFileReadOnlyA(InstanceID, InputFileName, Password);
        } else return 0;
    }

    public int DAPageRotation(int FileHandle, int PageRef) {
        if (LibraryLoaded) {
            return DPLDAPageRotation(InstanceID, FileHandle, PageRef);
        } else return 0;
    }

    public int DAReleaseImageList(int FileHandle, int ImageListID) {
        if (LibraryLoaded) {
            return DPLDAReleaseImageList(InstanceID, FileHandle, ImageListID);
        } else return 0;
    }

    public int DAReleaseTextBlocks(int TextBlockListID) {
        if (LibraryLoaded) {
            return DPLDAReleaseTextBlocks(InstanceID, TextBlockListID);
        } else return 0;
    }

    public int DARemoveUsageRights(int FileHandle) {
        if (LibraryLoaded) {
            return DPLDARemoveUsageRights(InstanceID, FileHandle);
        } else return 0;
    }

    public int DARenderPageToFile(int FileHandle, int PageRef, int Options, double DPI, String FileName) {
        if (LibraryLoaded) {
            return DPLDARenderPageToFileA(InstanceID, FileHandle, PageRef, Options, DPI, FileName);
        } else return 0;
    }

    public byte[] DARenderPageToString(int FileHandle, int PageRef, int Options, double DPI) {
        if (LibraryLoaded) {
            return DPLDARenderPageToString(InstanceID, FileHandle, PageRef, Options, DPI);
        } else return new byte[0];
    }

    public int DARotatePage(int FileHandle, int PageRef, int Angle, int Options) {
        if (LibraryLoaded) {
            return DPLDARotatePage(InstanceID, FileHandle, PageRef, Angle, Options);
        } else return 0;
    }

    public int DASaveAsFile(int FileHandle, String OutputFileName) {
        if (LibraryLoaded) {
            return DPLDASaveAsFileA(InstanceID, FileHandle, OutputFileName);
        } else return 0;
    }

    public int DASaveImageDataToFile(int FileHandle, int ImageListID, int ImageIndex, String ImageFileName) {
        if (LibraryLoaded) {
            return DPLDASaveImageDataToFileA(InstanceID, FileHandle, ImageListID, ImageIndex, ImageFileName);
        } else return 0;
    }

    public int DASetInformation(int FileHandle, String Key, String NewValue) {
        if (LibraryLoaded) {
            return DPLDASetInformationA(InstanceID, FileHandle, Key, NewValue);
        } else return 0;
    }

    public int DASetPageBox(int FileHandle, int PageRef, int BoxIndex, double X1, double Y1, double X2, double Y2) {
        if (LibraryLoaded) {
            return DPLDASetPageBox(InstanceID, FileHandle, PageRef, BoxIndex, X1, Y1, X2, Y2);
        } else return 0;
    }

    public int DASetPageLayout(int FileHandle, int NewPageLayout) {
        if (LibraryLoaded) {
            return DPLDASetPageLayout(InstanceID, FileHandle, NewPageLayout);
        } else return 0;
    }

    public int DASetPageMode(int FileHandle, int NewPageMode) {
        if (LibraryLoaded) {
            return DPLDASetPageMode(InstanceID, FileHandle, NewPageMode);
        } else return 0;
    }

    public int DASetPageSize(int FileHandle, int PageRef, double PntWidth, double PntHeight) {
        if (LibraryLoaded) {
            return DPLDASetPageSize(InstanceID, FileHandle, PageRef, PntWidth, PntHeight);
        } else return 0;
    }

    public int DASetRenderArea(double Left, double Top, double Width, double Height) {
        if (LibraryLoaded) {
            return DPLDASetRenderArea(InstanceID, Left, Top, Width, Height);
        } else return 0;
    }

    public int DASetTextExtractionArea(double Left, double Top, double Width, double Height) {
        if (LibraryLoaded) {
            return DPLDASetTextExtractionArea(InstanceID, Left, Top, Width, Height);
        } else return 0;
    }

    public int DASetTextExtractionOptions(int OptionID, int NewValue) {
        if (LibraryLoaded) {
            return DPLDASetTextExtractionOptions(InstanceID, OptionID, NewValue);
        } else return 0;
    }

    public int DASetTextExtractionScaling(int Options, double Horizontal, double Vertical) {
        if (LibraryLoaded) {
            return DPLDASetTextExtractionScaling(InstanceID, Options, Horizontal, Vertical);
        } else return 0;
    }

    public int DASetTextExtractionWordGap(double NewWordGap) {
        if (LibraryLoaded) {
            return DPLDASetTextExtractionWordGap(InstanceID, NewWordGap);
        } else return 0;
    }

    public int DAShiftedHeader(int FileHandle) {
        if (LibraryLoaded) {
            return DPLDAShiftedHeader(InstanceID, FileHandle);
        } else return 0;
    }

    public int Decrypt() {
        if (LibraryLoaded) {
            return DPLDecrypt(InstanceID);
        } else return 0;
    }

    public int DecryptFile(String InputFileName, String OutputFileName, String Password) {
        if (LibraryLoaded) {
            return DPLDecryptFileA(InstanceID, InputFileName, OutputFileName, Password);
        } else return 0;
    }

    public int DeleteAnalysis(int AnalysisID) {
        if (LibraryLoaded) {
            return DPLDeleteAnalysis(InstanceID, AnalysisID);
        } else return 0;
    }

    public int DeleteAnnotation(int Index) {
        if (LibraryLoaded) {
            return DPLDeleteAnnotation(InstanceID, Index);
        } else return 0;
    }

    public int DeleteContentStream() {
        if (LibraryLoaded) {
            return DPLDeleteContentStream(InstanceID);
        } else return 0;
    }

    public int DeleteFormField(int Index) {
        if (LibraryLoaded) {
            return DPLDeleteFormField(InstanceID, Index);
        } else return 0;
    }

    public int DeleteOptionalContentGroup(int OptionalContentGroupID) {
        if (LibraryLoaded) {
            return DPLDeleteOptionalContentGroup(InstanceID, OptionalContentGroupID);
        } else return 0;
    }

    public int DeletePageLGIDict(int DictIndex) {
        if (LibraryLoaded) {
            return DPLDeletePageLGIDict(InstanceID, DictIndex);
        } else return 0;
    }

    public int DeletePages(int StartPage, int PageCount) {
        if (LibraryLoaded) {
            return DPLDeletePages(InstanceID, StartPage, PageCount);
        } else return 0;
    }

    public int DocJavaScriptAction(String ActionType, String JavaScript) {
        if (LibraryLoaded) {
            return DPLDocJavaScriptActionA(InstanceID, ActionType, JavaScript);
        } else return 0;
    }

    public int DocumentCount() {
        if (LibraryLoaded) {
            return DPLDocumentCount(InstanceID);
        } else return 0;
    }

    public int DrawArc(double XPos, double YPos, double Radius, double StartAngle, double EndAngle, int Pie, int DrawOptions) {
        if (LibraryLoaded) {
            return DPLDrawArc(InstanceID, XPos, YPos, Radius, StartAngle, EndAngle, Pie, DrawOptions);
        } else return 0;
    }

    public int DrawBarcode(double Left, double Top, double Width, double Height, String Text, int Barcode, int Options) {
        if (LibraryLoaded) {
            return DPLDrawBarcodeA(InstanceID, Left, Top, Width, Height, Text, Barcode, Options);
        } else return 0;
    }

    public int DrawBox(double Left, double Top, double Width, double Height, int DrawOptions) {
        if (LibraryLoaded) {
            return DPLDrawBox(InstanceID, Left, Top, Width, Height, DrawOptions);
        } else return 0;
    }

    public int DrawCapturedPage(int CaptureID, double Left, double Top, double Width, double Height) {
        if (LibraryLoaded) {
            return DPLDrawCapturedPage(InstanceID, CaptureID, Left, Top, Width, Height);
        } else return 0;
    }

    public int DrawCapturedPageMatrix(int CaptureID, double M11, double M12, double M21, double M22, double MDX, double MDY) {
        if (LibraryLoaded) {
            return DPLDrawCapturedPageMatrix(InstanceID, CaptureID, M11, M12, M21, M22, MDX, MDY);
        } else return 0;
    }

    public int DrawCircle(double XPos, double YPos, double Radius, int DrawOptions) {
        if (LibraryLoaded) {
            return DPLDrawCircle(InstanceID, XPos, YPos, Radius, DrawOptions);
        } else return 0;
    }

    public int DrawDataMatrixSymbol(double Left, double Top, double ModuleSize, String Text, int Encoding, int SymbolSize, int Options) {
        if (LibraryLoaded) {
            return DPLDrawDataMatrixSymbolA(InstanceID, Left, Top, ModuleSize, Text, Encoding, SymbolSize, Options);
        } else return 0;
    }

    public int DrawEllipse(double XPos, double YPos, double Width, double Height, int DrawOptions) {
        if (LibraryLoaded) {
            return DPLDrawEllipse(InstanceID, XPos, YPos, Width, Height, DrawOptions);
        } else return 0;
    }

    public int DrawEllipticArc(double XPos, double YPos, double Width, double Height, double StartAngle, double EndAngle, int Pie, int DrawOptions) {
        if (LibraryLoaded) {
            return DPLDrawEllipticArc(InstanceID, XPos, YPos, Width, Height, StartAngle, EndAngle, Pie, DrawOptions);
        } else return 0;
    }

    public int DrawHTMLText(double Left, double Top, double Width, String HTMLText) {
        if (LibraryLoaded) {
            return DPLDrawHTMLTextA(InstanceID, Left, Top, Width, HTMLText);
        } else return 0;
    }

    public String DrawHTMLTextBox(double Left, double Top, double Width, double Height, String HTMLText) {
        if (LibraryLoaded) {
            return DPLDrawHTMLTextBoxA(InstanceID, Left, Top, Width, Height, HTMLText);
        } else return "";
    }

    public String DrawHTMLTextBoxMatrix(double Width, double Height, String HTMLText, double M11, double M12, double M21, double M22, double MDX, double MDY) {
        if (LibraryLoaded) {
            return DPLDrawHTMLTextBoxMatrixA(InstanceID, Width, Height, HTMLText, M11, M12, M21, M22, MDX, MDY);
        } else return "";
    }

    public int DrawHTMLTextMatrix(double Width, String HTMLText, double M11, double M12, double M21, double M22, double MDX, double MDY) {
        if (LibraryLoaded) {
            return DPLDrawHTMLTextMatrixA(InstanceID, Width, HTMLText, M11, M12, M21, M22, MDX, MDY);
        } else return 0;
    }

    public int DrawImage(double Left, double Top, double Width, double Height) {
        if (LibraryLoaded) {
            return DPLDrawImage(InstanceID, Left, Top, Width, Height);
        } else return 0;
    }

    public int DrawImageMatrix(double M11, double M12, double M21, double M22, double MDX, double MDY) {
        if (LibraryLoaded) {
            return DPLDrawImageMatrix(InstanceID, M11, M12, M21, M22, MDX, MDY);
        } else return 0;
    }

    public int DrawIntelligentMailBarcode(double Left, double Top, double BarWidth, double FullBarHeight, double TrackerHeight, double SpaceWidth, String BarcodeData, int Options) {
        if (LibraryLoaded) {
            return DPLDrawIntelligentMailBarcodeA(InstanceID, Left, Top, BarWidth, FullBarHeight, TrackerHeight, SpaceWidth, BarcodeData, Options);
        } else return 0;
    }

    public int DrawLine(double StartX, double StartY, double EndX, double EndY) {
        if (LibraryLoaded) {
            return DPLDrawLine(InstanceID, StartX, StartY, EndX, EndY);
        } else return 0;
    }

    public int DrawMultiLineText(double XPos, double YPos, String Delimiter, String Text) {
        if (LibraryLoaded) {
            return DPLDrawMultiLineTextA(InstanceID, XPos, YPos, Delimiter, Text);
        } else return 0;
    }

    public int DrawPDF417Symbol(double Left, double Top, String Text, int Options) {
        if (LibraryLoaded) {
            return DPLDrawPDF417SymbolA(InstanceID, Left, Top, Text, Options);
        } else return 0;
    }

    public int DrawPDF417SymbolEx(double Left, double Top, String Text, int Options, int FixedColumns, int FixedRows, int ErrorLevel, double ModuleSize, double HeightWidthRatio) {
        if (LibraryLoaded) {
            return DPLDrawPDF417SymbolExA(InstanceID, Left, Top, Text, Options, FixedColumns, FixedRows, ErrorLevel, ModuleSize, HeightWidthRatio);
        } else return 0;
    }

    public int DrawPath(int PathOptions) {
        if (LibraryLoaded) {
            return DPLDrawPath(InstanceID, PathOptions);
        } else return 0;
    }

    public int DrawPathEvenOdd(int PathOptions) {
        if (LibraryLoaded) {
            return DPLDrawPathEvenOdd(InstanceID, PathOptions);
        } else return 0;
    }

    public int DrawPostScriptXObject(int PSRef) {
        if (LibraryLoaded) {
            return DPLDrawPostScriptXObject(InstanceID, PSRef);
        } else return 0;
    }

    public int DrawQRCode(double Left, double Top, double SymbolSize, String Text, int EncodeOptions, int DrawOptions) {
        if (LibraryLoaded) {
            return DPLDrawQRCodeA(InstanceID, Left, Top, SymbolSize, Text, EncodeOptions, DrawOptions);
        } else return 0;
    }

    public int DrawRotatedBox(double Left, double Bottom, double Width, double Height, double Angle, int DrawOptions) {
        if (LibraryLoaded) {
            return DPLDrawRotatedBox(InstanceID, Left, Bottom, Width, Height, Angle, DrawOptions);
        } else return 0;
    }

    public int DrawRotatedCapturedPage(int CaptureID, double Left, double Bottom, double Width, double Height, double Angle) {
        if (LibraryLoaded) {
            return DPLDrawRotatedCapturedPage(InstanceID, CaptureID, Left, Bottom, Width, Height, Angle);
        } else return 0;
    }

    public int DrawRotatedImage(double Left, double Bottom, double Width, double Height, double Angle) {
        if (LibraryLoaded) {
            return DPLDrawRotatedImage(InstanceID, Left, Bottom, Width, Height, Angle);
        } else return 0;
    }

    public int DrawRotatedMultiLineText(double XPos, double YPos, double Angle, String Delimiter, String Text) {
        if (LibraryLoaded) {
            return DPLDrawRotatedMultiLineTextA(InstanceID, XPos, YPos, Angle, Delimiter, Text);
        } else return 0;
    }

    public int DrawRotatedText(double XPos, double YPos, double Angle, String Text) {
        if (LibraryLoaded) {
            return DPLDrawRotatedTextA(InstanceID, XPos, YPos, Angle, Text);
        } else return 0;
    }

    public int DrawRotatedTextBox(double Left, double Top, double Width, double Height, double Angle, String Text, int Options) {
        if (LibraryLoaded) {
            return DPLDrawRotatedTextBoxA(InstanceID, Left, Top, Width, Height, Angle, Text, Options);
        } else return 0;
    }

    public int DrawRotatedTextBoxEx(double Left, double Top, double Width, double Height, double Angle, String Text, int Options, int Border, int Radius, int DrawOptions) {
        if (LibraryLoaded) {
            return DPLDrawRotatedTextBoxExA(InstanceID, Left, Top, Width, Height, Angle, Text, Options, Border, Radius, DrawOptions);
        } else return 0;
    }

    public int DrawRoundedBox(double Left, double Top, double Width, double Height, double Radius, int DrawOptions) {
        if (LibraryLoaded) {
            return DPLDrawRoundedBox(InstanceID, Left, Top, Width, Height, Radius, DrawOptions);
        } else return 0;
    }

    public int DrawRoundedRotatedBox(double Left, double Bottom, double Width, double Height, double Radius, double Angle, int DrawOptions) {
        if (LibraryLoaded) {
            return DPLDrawRoundedRotatedBox(InstanceID, Left, Bottom, Width, Height, Radius, Angle, DrawOptions);
        } else return 0;
    }

    public int DrawScaledImage(double Left, double Top, double Scale) {
        if (LibraryLoaded) {
            return DPLDrawScaledImage(InstanceID, Left, Top, Scale);
        } else return 0;
    }

    public int DrawSpacedText(double XPos, double YPos, double Spacing, String Text) {
        if (LibraryLoaded) {
            return DPLDrawSpacedTextA(InstanceID, XPos, YPos, Spacing, Text);
        } else return 0;
    }

    public double DrawTableRows(int TableID, double Left, double Top, double Height, int FirstRow, int LastRow) {
        if (LibraryLoaded) {
            return DPLDrawTableRows(InstanceID, TableID, Left, Top, Height, FirstRow, LastRow);
        } else return 0;
    }

    public int DrawText(double XPos, double YPos, String Text) {
        if (LibraryLoaded) {
            return DPLDrawTextA(InstanceID, XPos, YPos, Text);
        } else return 0;
    }

    public int DrawTextArc(double XPos, double YPos, double Radius, double Angle, String Text, int DrawOptions) {
        if (LibraryLoaded) {
            return DPLDrawTextArcA(InstanceID, XPos, YPos, Radius, Angle, Text, DrawOptions);
        } else return 0;
    }

    public int DrawTextBox(double Left, double Top, double Width, double Height, String Text, int Options) {
        if (LibraryLoaded) {
            return DPLDrawTextBoxA(InstanceID, Left, Top, Width, Height, Text, Options);
        } else return 0;
    }

    public int DrawTextBoxMatrix(double Width, double Height, String Text, int Options, double M11, double M12, double M21, double M22, double MDX, double MDY) {
        if (LibraryLoaded) {
            return DPLDrawTextBoxMatrixA(InstanceID, Width, Height, Text, Options, M11, M12, M21, M22, MDX, MDY);
        } else return 0;
    }

    public int DrawWrappedText(double XPos, double YPos, double Width, String Text) {
        if (LibraryLoaded) {
            return DPLDrawWrappedTextA(InstanceID, XPos, YPos, Width, Text);
        } else return 0;
    }

    public int EditableContentStream() {
        if (LibraryLoaded) {
            return DPLEditableContentStream(InstanceID);
        } else return 0;
    }

    public int EmbedFile(String Title, String FileName, String MIMEType) {
        if (LibraryLoaded) {
            return DPLEmbedFileA(InstanceID, Title, FileName, MIMEType);
        } else return 0;
    }

    public int EmbedRelatedFile(String Title, String FileName, String MIMEType, String AFRelationship, int Options) {
        if (LibraryLoaded) {
            return DPLEmbedRelatedFileA(InstanceID, Title, FileName, MIMEType, AFRelationship, Options);
        } else return 0;
    }

    public int EmbeddedFileCount() {
        if (LibraryLoaded) {
            return DPLEmbeddedFileCount(InstanceID);
        } else return 0;
    }

    public int EncapsulateContentStream() {
        if (LibraryLoaded) {
            return DPLEncapsulateContentStream(InstanceID);
        } else return 0;
    }

    public int EncodePermissions(int CanPrint, int CanCopy, int CanChange, int CanAddNotes, int CanFillFields, int CanCopyAccess, int CanAssemble, int CanPrintFull) {
        if (LibraryLoaded) {
            return DPLEncodePermissions(InstanceID, CanPrint, CanCopy, CanChange, CanAddNotes, CanFillFields, CanCopyAccess, CanAssemble, CanPrintFull);
        } else return 0;
    }

    public int Encrypt(String Owner, String User, int Strength, int Permissions) {
        if (LibraryLoaded) {
            return DPLEncryptA(InstanceID, Owner, User, Strength, Permissions);
        } else return 0;
    }

    public int EncryptFile(String InputFileName, String OutputFileName, String Owner, String User, int Strength, int Permissions) {
        if (LibraryLoaded) {
            return DPLEncryptFileA(InstanceID, InputFileName, OutputFileName, Owner, User, Strength, Permissions);
        } else return 0;
    }

    public int EncryptWithFingerprint(String Fingerprint) {
        if (LibraryLoaded) {
            return DPLEncryptWithFingerprintA(InstanceID, Fingerprint);
        } else return 0;
    }

    public int EncryptionAlgorithm() {
        if (LibraryLoaded) {
            return DPLEncryptionAlgorithm(InstanceID);
        } else return 0;
    }

    public int EncryptionStatus() {
        if (LibraryLoaded) {
            return DPLEncryptionStatus(InstanceID);
        } else return 0;
    }

    public int EncryptionStrength() {
        if (LibraryLoaded) {
            return DPLEncryptionStrength(InstanceID);
        } else return 0;
    }

    public int EndPageUpdate() {
        if (LibraryLoaded) {
            return DPLEndPageUpdate(InstanceID);
        } else return 0;
    }

    public int EndSignProcessToFile(int SignProcessID, String OutputFile) {
        if (LibraryLoaded) {
            return DPLEndSignProcessToFileA(InstanceID, SignProcessID, OutputFile);
        } else return 0;
    }

    public byte[] EndSignProcessToString(int SignProcessID) {
        if (LibraryLoaded) {
            return DPLEndSignProcessToString(InstanceID, SignProcessID);
        } else return new byte[0];
    }

    public byte[] ExtractFilePageContentToString(String InputFileName, String Password, int Page) {
        if (LibraryLoaded) {
            return DPLExtractFilePageContentToStringA(InstanceID, InputFileName, Password, Page);
        } else return new byte[0];
    }

    public String ExtractFilePageText(String InputFileName, String Password, int Page, int Options) {
        if (LibraryLoaded) {
            return DPLExtractFilePageTextA(InstanceID, InputFileName, Password, Page, Options);
        } else return "";
    }

    public int ExtractFilePageTextBlocks(String InputFileName, String Password, int Page, int Options) {
        if (LibraryLoaded) {
            return DPLExtractFilePageTextBlocksA(InstanceID, InputFileName, Password, Page, Options);
        } else return 0;
    }

    public int ExtractFilePages(String InputFileName, String Password, String OutputFileName, String RangeList) {
        if (LibraryLoaded) {
            return DPLExtractFilePagesA(InstanceID, InputFileName, Password, OutputFileName, RangeList);
        } else return 0;
    }

    public int ExtractFilePagesEx(String InputFileName, String Password, String OutputFileName, String RangeList, int Options) {
        if (LibraryLoaded) {
            return DPLExtractFilePagesExA(InstanceID, InputFileName, Password, OutputFileName, RangeList, Options);
        } else return 0;
    }

    public int ExtractPageRanges(String RangeList) {
        if (LibraryLoaded) {
            return DPLExtractPageRangesA(InstanceID, RangeList);
        } else return 0;
    }

    public int ExtractPageTextBlocks(int ExtractOptions) {
        if (LibraryLoaded) {
            return DPLExtractPageTextBlocks(InstanceID, ExtractOptions);
        } else return 0;
    }

    public int ExtractPages(int StartPage, int PageCount) {
        if (LibraryLoaded) {
            return DPLExtractPages(InstanceID, StartPage, PageCount);
        } else return 0;
    }

    public int FileListCount(String ListName) {
        if (LibraryLoaded) {
            return DPLFileListCountA(InstanceID, ListName);
        } else return 0;
    }

    public String FileListItem(String ListName, int Index) {
        if (LibraryLoaded) {
            return DPLFileListItemA(InstanceID, ListName, Index);
        } else return "";
    }

    public int FindFonts() {
        if (LibraryLoaded) {
            return DPLFindFonts(InstanceID);
        } else return 0;
    }

    public int FindFormFieldByTitle(String Title) {
        if (LibraryLoaded) {
            return DPLFindFormFieldByTitleA(InstanceID, Title);
        } else return 0;
    }

    public int FindImages() {
        if (LibraryLoaded) {
            return DPLFindImages(InstanceID);
        } else return 0;
    }

    public int FitImage(double Left, double Top, double Width, double Height, int HAlign, int VAlign, int Rotate) {
        if (LibraryLoaded) {
            return DPLFitImage(InstanceID, Left, Top, Width, Height, HAlign, VAlign, Rotate);
        } else return 0;
    }

    public int FitRotatedTextBox(double Left, double Top, double Width, double Height, double Angle, String Text, int Options) {
        if (LibraryLoaded) {
            return DPLFitRotatedTextBoxA(InstanceID, Left, Top, Width, Height, Angle, Text, Options);
        } else return 0;
    }

    public int FitTextBox(double Left, double Top, double Width, double Height, String Text, int Options) {
        if (LibraryLoaded) {
            return DPLFitTextBoxA(InstanceID, Left, Top, Width, Height, Text, Options);
        } else return 0;
    }

    public int FlattenAllFormFields(int Options) {
        if (LibraryLoaded) {
            return DPLFlattenAllFormFields(InstanceID, Options);
        } else return 0;
    }

    public int FlattenAnnot(int Index, int Options) {
        if (LibraryLoaded) {
            return DPLFlattenAnnot(InstanceID, Index, Options);
        } else return 0;
    }

    public int FlattenFormField(int Index) {
        if (LibraryLoaded) {
            return DPLFlattenFormField(InstanceID, Index);
        } else return 0;
    }

    public int FontCount() {
        if (LibraryLoaded) {
            return DPLFontCount(InstanceID);
        } else return 0;
    }

    public String FontFamily() {
        if (LibraryLoaded) {
            return DPLFontFamilyA(InstanceID);
        } else return "";
    }

    public int FontHasKerning() {
        if (LibraryLoaded) {
            return DPLFontHasKerning(InstanceID);
        } else return 0;
    }

    public String FontName() {
        if (LibraryLoaded) {
            return DPLFontNameA(InstanceID);
        } else return "";
    }

    public String FontReference() {
        if (LibraryLoaded) {
            return DPLFontReferenceA(InstanceID);
        } else return "";
    }

    public int FontSize() {
        if (LibraryLoaded) {
            return DPLFontSize(InstanceID);
        } else return 0;
    }

    public int FontType() {
        if (LibraryLoaded) {
            return DPLFontType(InstanceID);
        } else return 0;
    }

    public int FormFieldCount() {
        if (LibraryLoaded) {
            return DPLFormFieldCount(InstanceID);
        } else return 0;
    }

    public int FormFieldHasParent(int Index) {
        if (LibraryLoaded) {
            return DPLFormFieldHasParent(InstanceID, Index);
        } else return 0;
    }

    public int FormFieldJavaScriptAction(int Index, String ActionType, String JavaScript) {
        if (LibraryLoaded) {
            return DPLFormFieldJavaScriptActionA(InstanceID, Index, ActionType, JavaScript);
        } else return 0;
    }

    public int FormFieldWebLinkAction(int Index, String ActionType, String Link) {
        if (LibraryLoaded) {
            return DPLFormFieldWebLinkActionA(InstanceID, Index, ActionType, Link);
        } else return 0;
    }

    public int GetActionDest(int ActionID) {
        if (LibraryLoaded) {
            return DPLGetActionDest(InstanceID, ActionID);
        } else return 0;
    }

    public String GetActionType(int ActionID) {
        if (LibraryLoaded) {
            return DPLGetActionTypeA(InstanceID, ActionID);
        } else return "";
    }

    public String GetActionURL(int ActionID) {
        if (LibraryLoaded) {
            return DPLGetActionURLA(InstanceID, ActionID);
        } else return "";
    }

    public String GetAnalysisInfo(int AnalysisID, int AnalysisItem) {
        if (LibraryLoaded) {
            return DPLGetAnalysisInfoA(InstanceID, AnalysisID, AnalysisItem);
        } else return "";
    }

    public int GetAnnotActionID(int Index) {
        if (LibraryLoaded) {
            return DPLGetAnnotActionID(InstanceID, Index);
        } else return 0;
    }

    public double GetAnnotDblProperty(int Index, int Tag) {
        if (LibraryLoaded) {
            return DPLGetAnnotDblProperty(InstanceID, Index, Tag);
        } else return 0;
    }

    public int GetAnnotDest(int Index) {
        if (LibraryLoaded) {
            return DPLGetAnnotDest(InstanceID, Index);
        } else return 0;
    }

    public String GetAnnotEmbeddedFileName(int Index, int Options) {
        if (LibraryLoaded) {
            return DPLGetAnnotEmbeddedFileNameA(InstanceID, Index, Options);
        } else return "";
    }

    public int GetAnnotEmbeddedFileToFile(int Index, int Options, String FileName) {
        if (LibraryLoaded) {
            return DPLGetAnnotEmbeddedFileToFileA(InstanceID, Index, Options, FileName);
        } else return 0;
    }

    public byte[] GetAnnotEmbeddedFileToString(int Index, int Options) {
        if (LibraryLoaded) {
            return DPLGetAnnotEmbeddedFileToString(InstanceID, Index, Options);
        } else return new byte[0];
    }

    public int GetAnnotIntProperty(int Index, int Tag) {
        if (LibraryLoaded) {
            return DPLGetAnnotIntProperty(InstanceID, Index, Tag);
        } else return 0;
    }

    public int GetAnnotQuadCount(int Index) {
        if (LibraryLoaded) {
            return DPLGetAnnotQuadCount(InstanceID, Index);
        } else return 0;
    }

    public double GetAnnotQuadPoints(int Index, int QuadNumber, int PointNumber) {
        if (LibraryLoaded) {
            return DPLGetAnnotQuadPoints(InstanceID, Index, QuadNumber, PointNumber);
        } else return 0;
    }

    public int GetAnnotSoundToFile(int Index, int Options, String SoundFileName) {
        if (LibraryLoaded) {
            return DPLGetAnnotSoundToFileA(InstanceID, Index, Options, SoundFileName);
        } else return 0;
    }

    public byte[] GetAnnotSoundToString(int Index, int Options) {
        if (LibraryLoaded) {
            return DPLGetAnnotSoundToString(InstanceID, Index, Options);
        } else return new byte[0];
    }

    public String GetAnnotStrProperty(int Index, int Tag) {
        if (LibraryLoaded) {
            return DPLGetAnnotStrPropertyA(InstanceID, Index, Tag);
        } else return "";
    }

    public double GetBarcodeWidth(double NominalWidth, String Text, int Barcode) {
        if (LibraryLoaded) {
            return DPLGetBarcodeWidthA(InstanceID, NominalWidth, Text, Barcode);
        } else return 0;
    }

    public String GetBaseURL() {
        if (LibraryLoaded) {
            return DPLGetBaseURLA(InstanceID);
        } else return "";
    }

    public int GetCSDictEPSG(int CSDictID) {
        if (LibraryLoaded) {
            return DPLGetCSDictEPSG(InstanceID, CSDictID);
        } else return 0;
    }

    public int GetCSDictType(int CSDictID) {
        if (LibraryLoaded) {
            return DPLGetCSDictType(InstanceID, CSDictID);
        } else return 0;
    }

    public String GetCSDictWKT(int CSDictID) {
        if (LibraryLoaded) {
            return DPLGetCSDictWKTA(InstanceID, CSDictID);
        } else return "";
    }

    public String GetCatalogInformation(String Key) {
        if (LibraryLoaded) {
            return DPLGetCatalogInformationA(InstanceID, Key);
        } else return "";
    }

    public byte[] GetContentStreamToString() {
        if (LibraryLoaded) {
            return DPLGetContentStreamToString(InstanceID);
        } else return new byte[0];
    }

    public String GetCustomInformation(String Key) {
        if (LibraryLoaded) {
            return DPLGetCustomInformationA(InstanceID, Key);
        } else return "";
    }

    public String GetCustomKeys(int Location) {
        if (LibraryLoaded) {
            return DPLGetCustomKeysA(InstanceID, Location);
        } else return "";
    }

    public String GetDestName(int DestID) {
        if (LibraryLoaded) {
            return DPLGetDestNameA(InstanceID, DestID);
        } else return "";
    }

    public int GetDestPage(int DestID) {
        if (LibraryLoaded) {
            return DPLGetDestPage(InstanceID, DestID);
        } else return 0;
    }

    public int GetDestType(int DestID) {
        if (LibraryLoaded) {
            return DPLGetDestType(InstanceID, DestID);
        } else return 0;
    }

    public double GetDestValue(int DestID, int ValueKey) {
        if (LibraryLoaded) {
            return DPLGetDestValue(InstanceID, DestID, ValueKey);
        } else return 0;
    }

    public String GetDocJavaScript(String ActionType) {
        if (LibraryLoaded) {
            return DPLGetDocJavaScriptA(InstanceID, ActionType);
        } else return "";
    }

    public String GetDocumentFileName() {
        if (LibraryLoaded) {
            return DPLGetDocumentFileNameA(InstanceID);
        } else return "";
    }

    public int GetDocumentFileSize() {
        if (LibraryLoaded) {
            return DPLGetDocumentFileSize(InstanceID);
        } else return 0;
    }

    public int GetDocumentID(int Index) {
        if (LibraryLoaded) {
            return DPLGetDocumentID(InstanceID, Index);
        } else return 0;
    }

    public String GetDocumentIdentifier(int Part, int Options) {
        if (LibraryLoaded) {
            return DPLGetDocumentIdentifierA(InstanceID, Part, Options);
        } else return "";
    }

    public String GetDocumentMetadata() {
        if (LibraryLoaded) {
            return DPLGetDocumentMetadataA(InstanceID);
        } else return "";
    }

    public int GetDocumentRepaired() {
        if (LibraryLoaded) {
            return DPLGetDocumentRepaired(InstanceID);
        } else return 0;
    }

    public String GetDocumentResourceList() {
        if (LibraryLoaded) {
            return DPLGetDocumentResourceListA(InstanceID);
        } else return "";
    }

    public int GetEmbeddedFileContentToFile(int Index, String FileName) {
        if (LibraryLoaded) {
            return DPLGetEmbeddedFileContentToFileA(InstanceID, Index, FileName);
        } else return 0;
    }

    public byte[] GetEmbeddedFileContentToString(int Index) {
        if (LibraryLoaded) {
            return DPLGetEmbeddedFileContentToString(InstanceID, Index);
        } else return new byte[0];
    }

    public int GetEmbeddedFileID(int Index) {
        if (LibraryLoaded) {
            return DPLGetEmbeddedFileID(InstanceID, Index);
        } else return 0;
    }

    public int GetEmbeddedFileIntProperty(int Index, int Tag) {
        if (LibraryLoaded) {
            return DPLGetEmbeddedFileIntProperty(InstanceID, Index, Tag);
        } else return 0;
    }

    public String GetEmbeddedFileStrProperty(int Index, int Tag) {
        if (LibraryLoaded) {
            return DPLGetEmbeddedFileStrPropertyA(InstanceID, Index, Tag);
        } else return "";
    }

    public String GetEncryptionFingerprint() {
        if (LibraryLoaded) {
            return DPLGetEncryptionFingerprintA(InstanceID);
        } else return "";
    }

    public String GetFileMetadata(String InputFileName, String Password) {
        if (LibraryLoaded) {
            return DPLGetFileMetadataA(InstanceID, InputFileName, Password);
        } else return "";
    }

    public int GetFirstChildOutline(int OutlineID) {
        if (LibraryLoaded) {
            return DPLGetFirstChildOutline(InstanceID, OutlineID);
        } else return 0;
    }

    public int GetFirstOutline() {
        if (LibraryLoaded) {
            return DPLGetFirstOutline(InstanceID);
        } else return 0;
    }

    public byte[] GetFontCharacterCodesToString(String InputText) {
        if (LibraryLoaded) {
            return DPLGetFontCharacterCodesToStringA(InstanceID, InputText);
        } else return new byte[0];
    }

    public int GetFontEncoding() {
        if (LibraryLoaded) {
            return DPLGetFontEncoding(InstanceID);
        } else return 0;
    }

    public int GetFontFlags(int FontFlagItemID) {
        if (LibraryLoaded) {
            return DPLGetFontFlags(InstanceID, FontFlagItemID);
        } else return 0;
    }

    public int GetFontID(int Index) {
        if (LibraryLoaded) {
            return DPLGetFontID(InstanceID, Index);
        } else return 0;
    }

    public int GetFontIsEmbedded() {
        if (LibraryLoaded) {
            return DPLGetFontIsEmbedded(InstanceID);
        } else return 0;
    }

    public int GetFontIsSubsetted() {
        if (LibraryLoaded) {
            return DPLGetFontIsSubsetted(InstanceID);
        } else return 0;
    }

    public int GetFontMetrics(int MetricType) {
        if (LibraryLoaded) {
            return DPLGetFontMetrics(InstanceID, MetricType);
        } else return 0;
    }

    public int GetFontObjectNumber() {
        if (LibraryLoaded) {
            return DPLGetFontObjectNumber(InstanceID);
        } else return 0;
    }

    public int GetFormFieldActionID(int Index, String TriggerEvent) {
        if (LibraryLoaded) {
            return DPLGetFormFieldActionIDA(InstanceID, Index, TriggerEvent);
        } else return 0;
    }

    public int GetFormFieldAlignment(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldAlignment(InstanceID, Index);
        } else return 0;
    }

    public int GetFormFieldAnnotFlags(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldAnnotFlags(InstanceID, Index);
        } else return 0;
    }

    public double GetFormFieldBackgroundColor(int Index, int ColorComponent) {
        if (LibraryLoaded) {
            return DPLGetFormFieldBackgroundColor(InstanceID, Index, ColorComponent);
        } else return 0;
    }

    public int GetFormFieldBackgroundColorType(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldBackgroundColorType(InstanceID, Index);
        } else return 0;
    }

    public double GetFormFieldBorderColor(int Index, int ColorComponent) {
        if (LibraryLoaded) {
            return DPLGetFormFieldBorderColor(InstanceID, Index, ColorComponent);
        } else return 0;
    }

    public int GetFormFieldBorderColorType(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldBorderColorType(InstanceID, Index);
        } else return 0;
    }

    public double GetFormFieldBorderProperty(int Index, int PropKey) {
        if (LibraryLoaded) {
            return DPLGetFormFieldBorderProperty(InstanceID, Index, PropKey);
        } else return 0;
    }

    public int GetFormFieldBorderStyle(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldBorderStyle(InstanceID, Index);
        } else return 0;
    }

    public double GetFormFieldBound(int Index, int Edge) {
        if (LibraryLoaded) {
            return DPLGetFormFieldBound(InstanceID, Index, Edge);
        } else return 0;
    }

    public String GetFormFieldCaption(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldCaptionA(InstanceID, Index);
        } else return "";
    }

    public String GetFormFieldCaptionEx(int Index, int StringType) {
        if (LibraryLoaded) {
            return DPLGetFormFieldCaptionExA(InstanceID, Index, StringType);
        } else return "";
    }

    public int GetFormFieldCheckStyle(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldCheckStyle(InstanceID, Index);
        } else return 0;
    }

    public String GetFormFieldChildTitle(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldChildTitleA(InstanceID, Index);
        } else return "";
    }

    public int GetFormFieldChoiceType(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldChoiceType(InstanceID, Index);
        } else return 0;
    }

    public double GetFormFieldColor(int Index, int ColorComponent) {
        if (LibraryLoaded) {
            return DPLGetFormFieldColor(InstanceID, Index, ColorComponent);
        } else return 0;
    }

    public int GetFormFieldComb(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldComb(InstanceID, Index);
        } else return 0;
    }

    public String GetFormFieldDefaultValue(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldDefaultValueA(InstanceID, Index);
        } else return "";
    }

    public String GetFormFieldDescription(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldDescriptionA(InstanceID, Index);
        } else return "";
    }

    public int GetFormFieldFlags(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldFlags(InstanceID, Index);
        } else return 0;
    }

    public String GetFormFieldFontName(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldFontNameA(InstanceID, Index);
        } else return "";
    }

    public String GetFormFieldJavaScript(int Index, String ActionType) {
        if (LibraryLoaded) {
            return DPLGetFormFieldJavaScriptA(InstanceID, Index, ActionType);
        } else return "";
    }

    public int GetFormFieldKidCount(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldKidCount(InstanceID, Index);
        } else return 0;
    }

    public int GetFormFieldKidTempIndex(int Index, int SubIndex) {
        if (LibraryLoaded) {
            return DPLGetFormFieldKidTempIndex(InstanceID, Index, SubIndex);
        } else return 0;
    }

    public int GetFormFieldMaxLen(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldMaxLen(InstanceID, Index);
        } else return 0;
    }

    public int GetFormFieldNoExport(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldNoExport(InstanceID, Index);
        } else return 0;
    }

    public int GetFormFieldPage(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldPage(InstanceID, Index);
        } else return 0;
    }

    public int GetFormFieldPrintable(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldPrintable(InstanceID, Index);
        } else return 0;
    }

    public int GetFormFieldReadOnly(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldReadOnly(InstanceID, Index);
        } else return 0;
    }

    public int GetFormFieldRequired(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldRequired(InstanceID, Index);
        } else return 0;
    }

    public String GetFormFieldRichTextString(int Index, String Key) {
        if (LibraryLoaded) {
            return DPLGetFormFieldRichTextStringA(InstanceID, Index, Key);
        } else return "";
    }

    public int GetFormFieldRotation(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldRotation(InstanceID, Index);
        } else return 0;
    }

    public int GetFormFieldSubCount(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldSubCount(InstanceID, Index);
        } else return 0;
    }

    public String GetFormFieldSubDisplayName(int Index, int SubIndex) {
        if (LibraryLoaded) {
            return DPLGetFormFieldSubDisplayNameA(InstanceID, Index, SubIndex);
        } else return "";
    }

    public String GetFormFieldSubName(int Index, int SubIndex) {
        if (LibraryLoaded) {
            return DPLGetFormFieldSubNameA(InstanceID, Index, SubIndex);
        } else return "";
    }

    public String GetFormFieldSubmitActionString(int Index, String ActionType) {
        if (LibraryLoaded) {
            return DPLGetFormFieldSubmitActionStringA(InstanceID, Index, ActionType);
        } else return "";
    }

    public int GetFormFieldTabOrder(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldTabOrder(InstanceID, Index);
        } else return 0;
    }

    public int GetFormFieldTabOrderEx(int Index, int Options) {
        if (LibraryLoaded) {
            return DPLGetFormFieldTabOrderEx(InstanceID, Index, Options);
        } else return 0;
    }

    public int GetFormFieldTextFlags(int Index, int ValueKey) {
        if (LibraryLoaded) {
            return DPLGetFormFieldTextFlags(InstanceID, Index, ValueKey);
        } else return 0;
    }

    public double GetFormFieldTextSize(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldTextSize(InstanceID, Index);
        } else return 0;
    }

    public String GetFormFieldTitle(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldTitleA(InstanceID, Index);
        } else return "";
    }

    public int GetFormFieldType(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldType(InstanceID, Index);
        } else return 0;
    }

    public String GetFormFieldValue(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldValueA(InstanceID, Index);
        } else return "";
    }

    public String GetFormFieldValueByTitle(String Title) {
        if (LibraryLoaded) {
            return DPLGetFormFieldValueByTitleA(InstanceID, Title);
        } else return "";
    }

    public int GetFormFieldVisible(int Index) {
        if (LibraryLoaded) {
            return DPLGetFormFieldVisible(InstanceID, Index);
        } else return 0;
    }

    public String GetFormFieldWebLink(int Index, String ActionType) {
        if (LibraryLoaded) {
            return DPLGetFormFieldWebLinkA(InstanceID, Index, ActionType);
        } else return "";
    }

    public int GetFormFontCount() {
        if (LibraryLoaded) {
            return DPLGetFormFontCount(InstanceID);
        } else return 0;
    }

    public String GetFormFontName(int FontIndex) {
        if (LibraryLoaded) {
            return DPLGetFormFontNameA(InstanceID, FontIndex);
        } else return "";
    }

    public String GetGlobalJavaScript(String PackageName) {
        if (LibraryLoaded) {
            return DPLGetGlobalJavaScriptA(InstanceID, PackageName);
        } else return "";
    }

    public double GetHTMLTextHeight(double Width, String HTMLText) {
        if (LibraryLoaded) {
            return DPLGetHTMLTextHeightA(InstanceID, Width, HTMLText);
        } else return 0;
    }

    public int GetHTMLTextLineCount(double Width, String HTMLText) {
        if (LibraryLoaded) {
            return DPLGetHTMLTextLineCountA(InstanceID, Width, HTMLText);
        } else return 0;
    }

    public double GetHTMLTextWidth(double MaxWidth, String HTMLText) {
        if (LibraryLoaded) {
            return DPLGetHTMLTextWidthA(InstanceID, MaxWidth, HTMLText);
        } else return 0;
    }

    public int GetImageID(int Index) {
        if (LibraryLoaded) {
            return DPLGetImageID(InstanceID, Index);
        } else return 0;
    }

    public int GetImageListCount(int ImageListID) {
        if (LibraryLoaded) {
            return DPLGetImageListCount(InstanceID, ImageListID);
        } else return 0;
    }

    public byte[] GetImageListItemDataToString(int ImageListID, int ImageIndex, int Options) {
        if (LibraryLoaded) {
            return DPLGetImageListItemDataToString(InstanceID, ImageListID, ImageIndex, Options);
        } else return new byte[0];
    }

    public double GetImageListItemDblProperty(int ImageListID, int ImageIndex, int PropertyID) {
        if (LibraryLoaded) {
            return DPLGetImageListItemDblProperty(InstanceID, ImageListID, ImageIndex, PropertyID);
        } else return 0;
    }

    public String GetImageListItemFormatDesc(int ImageListID, int ImageIndex, int Options) {
        if (LibraryLoaded) {
            return DPLGetImageListItemFormatDescA(InstanceID, ImageListID, ImageIndex, Options);
        } else return "";
    }

    public int GetImageListItemIntProperty(int ImageListID, int ImageIndex, int PropertyID) {
        if (LibraryLoaded) {
            return DPLGetImageListItemIntProperty(InstanceID, ImageListID, ImageIndex, PropertyID);
        } else return 0;
    }

    public int GetImageMeasureDict() {
        if (LibraryLoaded) {
            return DPLGetImageMeasureDict(InstanceID);
        } else return 0;
    }

    public int GetImagePageCount(String FileName) {
        if (LibraryLoaded) {
            return DPLGetImagePageCountA(InstanceID, FileName);
        } else return 0;
    }

    public int GetImagePageCountFromString(byte[] Source) {
        if (LibraryLoaded) {
            return DPLGetImagePageCountFromString(InstanceID, Source);
        } else return 0;
    }

    public int GetImagePtDataDict() {
        if (LibraryLoaded) {
            return DPLGetImagePtDataDict(InstanceID);
        } else return 0;
    }

    public String GetInformation(int Key) {
        if (LibraryLoaded) {
            return DPLGetInformationA(InstanceID, Key);
        } else return "";
    }

    public String GetInstalledFontsByCharset(int CharsetIndex, int Options) {
        if (LibraryLoaded) {
            return DPLGetInstalledFontsByCharsetA(InstanceID, CharsetIndex, Options);
        } else return "";
    }

    public String GetInstalledFontsByCodePage(int CodePage, int Options) {
        if (LibraryLoaded) {
            return DPLGetInstalledFontsByCodePageA(InstanceID, CodePage, Options);
        } else return "";
    }

    public int GetKerning(String CharPair) {
        if (LibraryLoaded) {
            return DPLGetKerningA(InstanceID, CharPair);
        } else return 0;
    }

    public int GetMaxObjectNumber() {
        if (LibraryLoaded) {
            return DPLGetMaxObjectNumber(InstanceID);
        } else return 0;
    }

    public int GetMeasureDictBoundsCount(int MeasureDictID) {
        if (LibraryLoaded) {
            return DPLGetMeasureDictBoundsCount(InstanceID, MeasureDictID);
        } else return 0;
    }

    public double GetMeasureDictBoundsItem(int MeasureDictID, int ItemIndex) {
        if (LibraryLoaded) {
            return DPLGetMeasureDictBoundsItem(InstanceID, MeasureDictID, ItemIndex);
        } else return 0;
    }

    public int GetMeasureDictCoordinateSystem(int MeasureDictID) {
        if (LibraryLoaded) {
            return DPLGetMeasureDictCoordinateSystem(InstanceID, MeasureDictID);
        } else return 0;
    }

    public int GetMeasureDictDCSDict(int MeasureDictID) {
        if (LibraryLoaded) {
            return DPLGetMeasureDictDCSDict(InstanceID, MeasureDictID);
        } else return 0;
    }

    public int GetMeasureDictGCSDict(int MeasureDictID) {
        if (LibraryLoaded) {
            return DPLGetMeasureDictGCSDict(InstanceID, MeasureDictID);
        } else return 0;
    }

    public int GetMeasureDictGPTSCount(int MeasureDictID) {
        if (LibraryLoaded) {
            return DPLGetMeasureDictGPTSCount(InstanceID, MeasureDictID);
        } else return 0;
    }

    public double GetMeasureDictGPTSItem(int MeasureDictID, int ItemIndex) {
        if (LibraryLoaded) {
            return DPLGetMeasureDictGPTSItem(InstanceID, MeasureDictID, ItemIndex);
        } else return 0;
    }

    public int GetMeasureDictLPTSCount(int MeasureDictID) {
        if (LibraryLoaded) {
            return DPLGetMeasureDictLPTSCount(InstanceID, MeasureDictID);
        } else return 0;
    }

    public double GetMeasureDictLPTSItem(int MeasureDictID, int ItemIndex) {
        if (LibraryLoaded) {
            return DPLGetMeasureDictLPTSItem(InstanceID, MeasureDictID, ItemIndex);
        } else return 0;
    }

    public int GetMeasureDictPDU(int MeasureDictID, int UnitIndex) {
        if (LibraryLoaded) {
            return DPLGetMeasureDictPDU(InstanceID, MeasureDictID, UnitIndex);
        } else return 0;
    }

    public int GetMeasurementUnits() {
        if (LibraryLoaded) {
            return DPLGetMeasurementUnits(InstanceID);
        } else return 0;
    }

    public int GetNamedDestination(String DestName) {
        if (LibraryLoaded) {
            return DPLGetNamedDestinationA(InstanceID, DestName);
        } else return 0;
    }

    public int GetNeedAppearances() {
        if (LibraryLoaded) {
            return DPLGetNeedAppearances(InstanceID);
        } else return 0;
    }

    public int GetNextOutline(int OutlineID) {
        if (LibraryLoaded) {
            return DPLGetNextOutline(InstanceID, OutlineID);
        } else return 0;
    }

    public int GetObjectCount() {
        if (LibraryLoaded) {
            return DPLGetObjectCount(InstanceID);
        } else return 0;
    }

    public int GetObjectDecodeError(int ObjectNumber) {
        if (LibraryLoaded) {
            return DPLGetObjectDecodeError(InstanceID, ObjectNumber);
        } else return 0;
    }

    public byte[] GetObjectToString(int ObjectNumber) {
        if (LibraryLoaded) {
            return DPLGetObjectToString(InstanceID, ObjectNumber);
        } else return new byte[0];
    }

    public int GetOpenActionDestination() {
        if (LibraryLoaded) {
            return DPLGetOpenActionDestination(InstanceID);
        } else return 0;
    }

    public String GetOpenActionJavaScript() {
        if (LibraryLoaded) {
            return DPLGetOpenActionJavaScriptA(InstanceID);
        } else return "";
    }

    public int GetOptionalContentConfigCount() {
        if (LibraryLoaded) {
            return DPLGetOptionalContentConfigCount(InstanceID);
        } else return 0;
    }

    public int GetOptionalContentConfigLocked(int OptionalContentConfigID, int OptionalContentGroupID) {
        if (LibraryLoaded) {
            return DPLGetOptionalContentConfigLocked(InstanceID, OptionalContentConfigID, OptionalContentGroupID);
        } else return 0;
    }

    public int GetOptionalContentConfigOrderCount(int OptionalContentConfigID) {
        if (LibraryLoaded) {
            return DPLGetOptionalContentConfigOrderCount(InstanceID, OptionalContentConfigID);
        } else return 0;
    }

    public int GetOptionalContentConfigOrderItemID(int OptionalContentConfigID, int ItemIndex) {
        if (LibraryLoaded) {
            return DPLGetOptionalContentConfigOrderItemID(InstanceID, OptionalContentConfigID, ItemIndex);
        } else return 0;
    }

    public String GetOptionalContentConfigOrderItemLabel(int OptionalContentConfigID, int ItemIndex) {
        if (LibraryLoaded) {
            return DPLGetOptionalContentConfigOrderItemLabelA(InstanceID, OptionalContentConfigID, ItemIndex);
        } else return "";
    }

    public int GetOptionalContentConfigOrderItemLevel(int OptionalContentConfigID, int ItemIndex) {
        if (LibraryLoaded) {
            return DPLGetOptionalContentConfigOrderItemLevel(InstanceID, OptionalContentConfigID, ItemIndex);
        } else return 0;
    }

    public int GetOptionalContentConfigOrderItemType(int OptionalContentConfigID, int ItemIndex) {
        if (LibraryLoaded) {
            return DPLGetOptionalContentConfigOrderItemType(InstanceID, OptionalContentConfigID, ItemIndex);
        } else return 0;
    }

    public int GetOptionalContentConfigState(int OptionalContentConfigID, int OptionalContentGroupID) {
        if (LibraryLoaded) {
            return DPLGetOptionalContentConfigState(InstanceID, OptionalContentConfigID, OptionalContentGroupID);
        } else return 0;
    }

    public int GetOptionalContentGroupID(int Index) {
        if (LibraryLoaded) {
            return DPLGetOptionalContentGroupID(InstanceID, Index);
        } else return 0;
    }

    public String GetOptionalContentGroupName(int OptionalContentGroupID) {
        if (LibraryLoaded) {
            return DPLGetOptionalContentGroupNameA(InstanceID, OptionalContentGroupID);
        } else return "";
    }

    public int GetOptionalContentGroupPrintable(int OptionalContentGroupID) {
        if (LibraryLoaded) {
            return DPLGetOptionalContentGroupPrintable(InstanceID, OptionalContentGroupID);
        } else return 0;
    }

    public int GetOptionalContentGroupVisible(int OptionalContentGroupID) {
        if (LibraryLoaded) {
            return DPLGetOptionalContentGroupVisible(InstanceID, OptionalContentGroupID);
        } else return 0;
    }

    public int GetOrigin() {
        if (LibraryLoaded) {
            return DPLGetOrigin(InstanceID);
        } else return 0;
    }

    public int GetOutlineActionID(int OutlineID) {
        if (LibraryLoaded) {
            return DPLGetOutlineActionID(InstanceID, OutlineID);
        } else return 0;
    }

    public double GetOutlineColor(int OutlineID, int ColorComponent) {
        if (LibraryLoaded) {
            return DPLGetOutlineColor(InstanceID, OutlineID, ColorComponent);
        } else return 0;
    }

    public int GetOutlineDest(int OutlineID) {
        if (LibraryLoaded) {
            return DPLGetOutlineDest(InstanceID, OutlineID);
        } else return 0;
    }

    public int GetOutlineID(int Index) {
        if (LibraryLoaded) {
            return DPLGetOutlineID(InstanceID, Index);
        } else return 0;
    }

    public String GetOutlineJavaScript(int OutlineID) {
        if (LibraryLoaded) {
            return DPLGetOutlineJavaScriptA(InstanceID, OutlineID);
        } else return "";
    }

    public int GetOutlineObjectNumber(int OutlineID) {
        if (LibraryLoaded) {
            return DPLGetOutlineObjectNumber(InstanceID, OutlineID);
        } else return 0;
    }

    public String GetOutlineOpenFile(int OutlineID) {
        if (LibraryLoaded) {
            return DPLGetOutlineOpenFileA(InstanceID, OutlineID);
        } else return "";
    }

    public int GetOutlinePage(int OutlineID) {
        if (LibraryLoaded) {
            return DPLGetOutlinePage(InstanceID, OutlineID);
        } else return 0;
    }

    public int GetOutlineStyle(int OutlineID) {
        if (LibraryLoaded) {
            return DPLGetOutlineStyle(InstanceID, OutlineID);
        } else return 0;
    }

    public String GetOutlineWebLink(int OutlineID) {
        if (LibraryLoaded) {
            return DPLGetOutlineWebLinkA(InstanceID, OutlineID);
        } else return "";
    }

    public double GetPDF417SymbolHeight(String Text, int Options, int FixedColumns, int FixedRows, int ErrorLevel, double ModuleSize, double HeightWidthRatio) {
        if (LibraryLoaded) {
            return DPLGetPDF417SymbolHeightA(InstanceID, Text, Options, FixedColumns, FixedRows, ErrorLevel, ModuleSize, HeightWidthRatio);
        } else return 0;
    }

    public double GetPDF417SymbolWidth(String Text, int Options, int FixedColumns, int FixedRows, int ErrorLevel, double ModuleSize, double HeightWidthRatio) {
        if (LibraryLoaded) {
            return DPLGetPDF417SymbolWidthA(InstanceID, Text, Options, FixedColumns, FixedRows, ErrorLevel, ModuleSize, HeightWidthRatio);
        } else return 0;
    }

    public double GetPageBox(int BoxType, int Dimension) {
        if (LibraryLoaded) {
            return DPLGetPageBox(InstanceID, BoxType, Dimension);
        } else return 0;
    }

    public String GetPageColorSpaces(int Options) {
        if (LibraryLoaded) {
            return DPLGetPageColorSpacesA(InstanceID, Options);
        } else return "";
    }

    public byte[] GetPageContentToString() {
        if (LibraryLoaded) {
            return DPLGetPageContentToString(InstanceID);
        } else return new byte[0];
    }

    public int GetPageImageList(int Options) {
        if (LibraryLoaded) {
            return DPLGetPageImageList(InstanceID, Options);
        } else return 0;
    }

    public String GetPageJavaScript(String ActionType) {
        if (LibraryLoaded) {
            return DPLGetPageJavaScriptA(InstanceID, ActionType);
        } else return "";
    }

    public String GetPageLGIDictContent(int DictIndex) {
        if (LibraryLoaded) {
            return DPLGetPageLGIDictContentA(InstanceID, DictIndex);
        } else return "";
    }

    public int GetPageLGIDictCount() {
        if (LibraryLoaded) {
            return DPLGetPageLGIDictCount(InstanceID);
        } else return 0;
    }

    public String GetPageLabel(int Page) {
        if (LibraryLoaded) {
            return DPLGetPageLabelA(InstanceID, Page);
        } else return "";
    }

    public int GetPageLayout() {
        if (LibraryLoaded) {
            return DPLGetPageLayout(InstanceID);
        } else return 0;
    }

    public byte[] GetPageMetricsToString(int StartPage, int EndPage, int Options) {
        if (LibraryLoaded) {
            return DPLGetPageMetricsToString(InstanceID, StartPage, EndPage, Options);
        } else return new byte[0];
    }

    public int GetPageMode() {
        if (LibraryLoaded) {
            return DPLGetPageMode(InstanceID);
        } else return 0;
    }

    public String GetPageText(int ExtractOptions) {
        if (LibraryLoaded) {
            return DPLGetPageTextA(InstanceID, ExtractOptions);
        } else return "";
    }

    public double GetPageUserUnit() {
        if (LibraryLoaded) {
            return DPLGetPageUserUnit(InstanceID);
        } else return 0;
    }

    public int GetPageViewPortCount() {
        if (LibraryLoaded) {
            return DPLGetPageViewPortCount(InstanceID);
        } else return 0;
    }

    public int GetPageViewPortID(int Index) {
        if (LibraryLoaded) {
            return DPLGetPageViewPortID(InstanceID, Index);
        } else return 0;
    }

    public int GetParentOutline(int OutlineID) {
        if (LibraryLoaded) {
            return DPLGetParentOutline(InstanceID, OutlineID);
        } else return 0;
    }

    public int GetPrevOutline(int OutlineID) {
        if (LibraryLoaded) {
            return DPLGetPrevOutline(InstanceID, OutlineID);
        } else return 0;
    }

    public byte[] GetPrintPreviewBitmapToString(String PrinterName, int PreviewPage, int PrintOptions, int MaxDimension, int PreviewOptions) {
        if (LibraryLoaded) {
            return DPLGetPrintPreviewBitmapToStringA(InstanceID, PrinterName, PreviewPage, PrintOptions, MaxDimension, PreviewOptions);
        } else return new byte[0];
    }

    public double GetRenderScale() {
        if (LibraryLoaded) {
            return DPLGetRenderScale(InstanceID);
        } else return 0;
    }

    public double GetScale() {
        if (LibraryLoaded) {
            return DPLGetScale(InstanceID);
        } else return 0;
    }

    public int GetSignProcessByteRange(int SignProcessID, int ArrayPosition) {
        if (LibraryLoaded) {
            return DPLGetSignProcessByteRange(InstanceID, SignProcessID, ArrayPosition);
        } else return 0;
    }

    public int GetSignProcessResult(int SignProcessID) {
        if (LibraryLoaded) {
            return DPLGetSignProcessResult(InstanceID, SignProcessID);
        } else return 0;
    }

    public int GetStringListCount(int StringListID) {
        if (LibraryLoaded) {
            return DPLGetStringListCount(InstanceID, StringListID);
        } else return 0;
    }

    public String GetStringListItem(int StringListID, int ItemIndex) {
        if (LibraryLoaded) {
            return DPLGetStringListItemA(InstanceID, StringListID, ItemIndex);
        } else return "";
    }

    public String GetTabOrderMode() {
        if (LibraryLoaded) {
            return DPLGetTabOrderModeA(InstanceID);
        } else return "";
    }

    public double GetTableCellDblProperty(int TableID, int RowNumber, int ColumnNumber, int Tag) {
        if (LibraryLoaded) {
            return DPLGetTableCellDblProperty(InstanceID, TableID, RowNumber, ColumnNumber, Tag);
        } else return 0;
    }

    public int GetTableCellIntProperty(int TableID, int RowNumber, int ColumnNumber, int Tag) {
        if (LibraryLoaded) {
            return DPLGetTableCellIntProperty(InstanceID, TableID, RowNumber, ColumnNumber, Tag);
        } else return 0;
    }

    public String GetTableCellStrProperty(int TableID, int RowNumber, int ColumnNumber, int Tag) {
        if (LibraryLoaded) {
            return DPLGetTableCellStrPropertyA(InstanceID, TableID, RowNumber, ColumnNumber, Tag);
        } else return "";
    }

    public int GetTableColumnCount(int TableID) {
        if (LibraryLoaded) {
            return DPLGetTableColumnCount(InstanceID, TableID);
        } else return 0;
    }

    public int GetTableLastDrawnRow(int TableID) {
        if (LibraryLoaded) {
            return DPLGetTableLastDrawnRow(InstanceID, TableID);
        } else return 0;
    }

    public int GetTableRowCount(int TableID) {
        if (LibraryLoaded) {
            return DPLGetTableRowCount(InstanceID, TableID);
        } else return 0;
    }

    public String GetTempPath() {
        if (LibraryLoaded) {
            return DPLGetTempPathA(InstanceID);
        } else return "";
    }

    public double GetTextAscent() {
        if (LibraryLoaded) {
            return DPLGetTextAscent(InstanceID);
        } else return 0;
    }

    public String GetTextBlockAsString(int TextBlockListID, int Index) {
        if (LibraryLoaded) {
            return DPLGetTextBlockAsStringA(InstanceID, TextBlockListID, Index);
        } else return "";
    }

    public double GetTextBlockBound(int TextBlockListID, int Index, int BoundIndex) {
        if (LibraryLoaded) {
            return DPLGetTextBlockBound(InstanceID, TextBlockListID, Index, BoundIndex);
        } else return 0;
    }

    public double GetTextBlockCharWidth(int TextBlockListID, int Index, int CharIndex) {
        if (LibraryLoaded) {
            return DPLGetTextBlockCharWidth(InstanceID, TextBlockListID, Index, CharIndex);
        } else return 0;
    }

    public double GetTextBlockColor(int TextBlockListID, int Index, int ColorComponent) {
        if (LibraryLoaded) {
            return DPLGetTextBlockColor(InstanceID, TextBlockListID, Index, ColorComponent);
        } else return 0;
    }

    public int GetTextBlockColorType(int TextBlockListID, int Index) {
        if (LibraryLoaded) {
            return DPLGetTextBlockColorType(InstanceID, TextBlockListID, Index);
        } else return 0;
    }

    public int GetTextBlockCount(int TextBlockListID) {
        if (LibraryLoaded) {
            return DPLGetTextBlockCount(InstanceID, TextBlockListID);
        } else return 0;
    }

    public String GetTextBlockFontName(int TextBlockListID, int Index) {
        if (LibraryLoaded) {
            return DPLGetTextBlockFontNameA(InstanceID, TextBlockListID, Index);
        } else return "";
    }

    public double GetTextBlockFontSize(int TextBlockListID, int Index) {
        if (LibraryLoaded) {
            return DPLGetTextBlockFontSize(InstanceID, TextBlockListID, Index);
        } else return 0;
    }

    public String GetTextBlockText(int TextBlockListID, int Index) {
        if (LibraryLoaded) {
            return DPLGetTextBlockTextA(InstanceID, TextBlockListID, Index);
        } else return "";
    }

    public double GetTextBound(int Edge) {
        if (LibraryLoaded) {
            return DPLGetTextBound(InstanceID, Edge);
        } else return 0;
    }

    public double GetTextDescent() {
        if (LibraryLoaded) {
            return DPLGetTextDescent(InstanceID);
        } else return 0;
    }

    public double GetTextHeight() {
        if (LibraryLoaded) {
            return DPLGetTextHeight(InstanceID);
        } else return 0;
    }

    public double GetTextSize() {
        if (LibraryLoaded) {
            return DPLGetTextSize(InstanceID);
        } else return 0;
    }

    public double GetTextWidth(String Text) {
        if (LibraryLoaded) {
            return DPLGetTextWidthA(InstanceID, Text);
        } else return 0;
    }

    public String GetUnicodeCharactersFromEncoding(int Encoding) {
        if (LibraryLoaded) {
            return DPLGetUnicodeCharactersFromEncodingA(InstanceID, Encoding);
        } else return "";
    }

    public double GetViewPortBBox(int ViewPortID, int Dimension) {
        if (LibraryLoaded) {
            return DPLGetViewPortBBox(InstanceID, ViewPortID, Dimension);
        } else return 0;
    }

    public int GetViewPortMeasureDict(int ViewPortID) {
        if (LibraryLoaded) {
            return DPLGetViewPortMeasureDict(InstanceID, ViewPortID);
        } else return 0;
    }

    public String GetViewPortName(int ViewPortID) {
        if (LibraryLoaded) {
            return DPLGetViewPortNameA(InstanceID, ViewPortID);
        } else return "";
    }

    public int GetViewPortPtDataDict(int ViewPortID) {
        if (LibraryLoaded) {
            return DPLGetViewPortPtDataDict(InstanceID, ViewPortID);
        } else return 0;
    }

    public int GetViewerPreferences(int Option) {
        if (LibraryLoaded) {
            return DPLGetViewerPreferences(InstanceID, Option);
        } else return 0;
    }

    public String GetWrappedText(double Width, String Delimiter, String Text) {
        if (LibraryLoaded) {
            return DPLGetWrappedTextA(InstanceID, Width, Delimiter, Text);
        } else return "";
    }

    public String GetWrappedTextBreakString(double Width, String Delimiter, String Text) {
        if (LibraryLoaded) {
            return DPLGetWrappedTextBreakStringA(InstanceID, Width, Delimiter, Text);
        } else return "";
    }

    public double GetWrappedTextHeight(double Width, String Text) {
        if (LibraryLoaded) {
            return DPLGetWrappedTextHeightA(InstanceID, Width, Text);
        } else return 0;
    }

    public int GetWrappedTextLineCount(double Width, String Text) {
        if (LibraryLoaded) {
            return DPLGetWrappedTextLineCountA(InstanceID, Width, Text);
        } else return 0;
    }

    public int GetXFAFormFieldCount() {
        if (LibraryLoaded) {
            return DPLGetXFAFormFieldCount(InstanceID);
        } else return 0;
    }

    public String GetXFAFormFieldName(int Index) {
        if (LibraryLoaded) {
            return DPLGetXFAFormFieldNameA(InstanceID, Index);
        } else return "";
    }

    public String GetXFAFormFieldNames(String Delimiter) {
        if (LibraryLoaded) {
            return DPLGetXFAFormFieldNamesA(InstanceID, Delimiter);
        } else return "";
    }

    public String GetXFAFormFieldValue(String XFAFieldName) {
        if (LibraryLoaded) {
            return DPLGetXFAFormFieldValueA(InstanceID, XFAFieldName);
        } else return "";
    }

    public byte[] GetXFAToString(int Options) {
        if (LibraryLoaded) {
            return DPLGetXFAToString(InstanceID, Options);
        } else return new byte[0];
    }

    public int GlobalJavaScriptCount() {
        if (LibraryLoaded) {
            return DPLGlobalJavaScriptCount(InstanceID);
        } else return 0;
    }

    public String GlobalJavaScriptPackageName(int Index) {
        if (LibraryLoaded) {
            return DPLGlobalJavaScriptPackageNameA(InstanceID, Index);
        } else return "";
    }

    public int HasFontResources() {
        if (LibraryLoaded) {
            return DPLHasFontResources(InstanceID);
        } else return 0;
    }

    public int HasPageBox(int BoxType) {
        if (LibraryLoaded) {
            return DPLHasPageBox(InstanceID, BoxType);
        } else return 0;
    }

    public int HidePage() {
        if (LibraryLoaded) {
            return DPLHidePage(InstanceID);
        } else return 0;
    }

    public int ImageCount() {
        if (LibraryLoaded) {
            return DPLImageCount(InstanceID);
        } else return 0;
    }

    public int ImageFillColor() {
        if (LibraryLoaded) {
            return DPLImageFillColor(InstanceID);
        } else return 0;
    }

    public int ImageHeight() {
        if (LibraryLoaded) {
            return DPLImageHeight(InstanceID);
        } else return 0;
    }

    public int ImageHorizontalResolution() {
        if (LibraryLoaded) {
            return DPLImageHorizontalResolution(InstanceID);
        } else return 0;
    }

    public int ImageResolutionUnits() {
        if (LibraryLoaded) {
            return DPLImageResolutionUnits(InstanceID);
        } else return 0;
    }

    public int ImageType() {
        if (LibraryLoaded) {
            return DPLImageType(InstanceID);
        } else return 0;
    }

    public int ImageVerticalResolution() {
        if (LibraryLoaded) {
            return DPLImageVerticalResolution(InstanceID);
        } else return 0;
    }

    public int ImageWidth() {
        if (LibraryLoaded) {
            return DPLImageWidth(InstanceID);
        } else return 0;
    }

    public int ImportEMFFromFile(String FileName, int FontOptions, int GeneralOptions) {
        if (LibraryLoaded) {
            return DPLImportEMFFromFileA(InstanceID, FileName, FontOptions, GeneralOptions);
        } else return 0;
    }

    public int InsertPages(int StartPage, int PageCount) {
        if (LibraryLoaded) {
            return DPLInsertPages(InstanceID, StartPage, PageCount);
        } else return 0;
    }

    public int InsertTableColumns(int TableID, int Position, int NewColumnCount) {
        if (LibraryLoaded) {
            return DPLInsertTableColumns(InstanceID, TableID, Position, NewColumnCount);
        } else return 0;
    }

    public int InsertTableRows(int TableID, int Position, int NewRowCount) {
        if (LibraryLoaded) {
            return DPLInsertTableRows(InstanceID, TableID, Position, NewRowCount);
        } else return 0;
    }

    public int IsAnnotFormField(int Index) {
        if (LibraryLoaded) {
            return DPLIsAnnotFormField(InstanceID, Index);
        } else return 0;
    }

    public int IsLinearized() {
        if (LibraryLoaded) {
            return DPLIsLinearized(InstanceID);
        } else return 0;
    }

    public int IsTaggedPDF() {
        if (LibraryLoaded) {
            return DPLIsTaggedPDF(InstanceID);
        } else return 0;
    }

    public int LastErrorCode() {
        if (LibraryLoaded) {
            return DPLLastErrorCode(InstanceID);
        } else return 0;
    }

    public String LastRenderError() {
        if (LibraryLoaded) {
            return DPLLastRenderErrorA(InstanceID);
        } else return "";
    }

    public String LibraryVersion() {
        if (LibraryLoaded) {
            return DPLLibraryVersionA(InstanceID);
        } else return "";
    }

    public String LibraryVersionEx() {
        if (LibraryLoaded) {
            return DPLLibraryVersionExA(InstanceID);
        } else return "";
    }

    public String LicenseInfo() {
        if (LibraryLoaded) {
            return DPLLicenseInfoA(InstanceID);
        } else return "";
    }

    public int LinearizeFile(String InputFileName, String Password, String OutputFileName, int Options) {
        if (LibraryLoaded) {
            return DPLLinearizeFileA(InstanceID, InputFileName, Password, OutputFileName, Options);
        } else return 0;
    }

    public int LoadFromFile(String FileName, String Password) {
        if (LibraryLoaded) {
            return DPLLoadFromFileA(InstanceID, FileName, Password);
        } else return 0;
    }

    public int LoadFromString(byte[] Source, String Password) {
        if (LibraryLoaded) {
            return DPLLoadFromStringA(InstanceID, Source, Password);
        } else return 0;
    }

    public int LoadState() {
        if (LibraryLoaded) {
            return DPLLoadState(InstanceID);
        } else return 0;
    }

    public int MergeDocument(int DocumentID) {
        if (LibraryLoaded) {
            return DPLMergeDocument(InstanceID, DocumentID);
        } else return 0;
    }

    public int MergeFileList(String ListName, String OutputFileName) {
        if (LibraryLoaded) {
            return DPLMergeFileListA(InstanceID, ListName, OutputFileName);
        } else return 0;
    }

    public int MergeFileListFast(String ListName, String OutputFileName) {
        if (LibraryLoaded) {
            return DPLMergeFileListFastA(InstanceID, ListName, OutputFileName);
        } else return 0;
    }

    public int MergeFiles(String FirstFileName, String SecondFileName, String OutputFileName) {
        if (LibraryLoaded) {
            return DPLMergeFilesA(InstanceID, FirstFileName, SecondFileName, OutputFileName);
        } else return 0;
    }

    public int MergeTableCells(int TableID, int FirstRow, int FirstColumn, int LastRow, int LastColumn) {
        if (LibraryLoaded) {
            return DPLMergeTableCells(InstanceID, TableID, FirstRow, FirstColumn, LastRow, LastColumn);
        } else return 0;
    }

    public int MoveContentStream(int FromPosition, int ToPosition) {
        if (LibraryLoaded) {
            return DPLMoveContentStream(InstanceID, FromPosition, ToPosition);
        } else return 0;
    }

    public int MoveOutlineAfter(int OutlineID, int SiblingID) {
        if (LibraryLoaded) {
            return DPLMoveOutlineAfter(InstanceID, OutlineID, SiblingID);
        } else return 0;
    }

    public int MoveOutlineBefore(int OutlineID, int SiblingID) {
        if (LibraryLoaded) {
            return DPLMoveOutlineBefore(InstanceID, OutlineID, SiblingID);
        } else return 0;
    }

    public int MovePage(int NewPosition) {
        if (LibraryLoaded) {
            return DPLMovePage(InstanceID, NewPosition);
        } else return 0;
    }

    public int MovePath(double NewX, double NewY) {
        if (LibraryLoaded) {
            return DPLMovePath(InstanceID, NewX, NewY);
        } else return 0;
    }

    public int MultiplyScale(double MultScaleBy) {
        if (LibraryLoaded) {
            return DPLMultiplyScale(InstanceID, MultScaleBy);
        } else return 0;
    }

    public int NewCMYKAxialShader(String ShaderName, double StartX, double StartY, double StartCyan, double StartMagenta, double StartYellow, double StartBlack, double EndX, double EndY, double EndCyan, double EndMagenta, double EndYellow, double EndBlack, int Extend) {
        if (LibraryLoaded) {
            return DPLNewCMYKAxialShaderA(InstanceID, ShaderName, StartX, StartY, StartCyan, StartMagenta, StartYellow, StartBlack, EndX, EndY, EndCyan, EndMagenta, EndYellow, EndBlack, Extend);
        } else return 0;
    }

    public int NewChildFormField(int Index, String Title, int FieldType) {
        if (LibraryLoaded) {
            return DPLNewChildFormFieldA(InstanceID, Index, Title, FieldType);
        } else return 0;
    }

    public int NewContentStream() {
        if (LibraryLoaded) {
            return DPLNewContentStream(InstanceID);
        } else return 0;
    }

    public int NewDestination(int DestPage, int Zoom, int DestType, double Left, double Top, double Right, double Bottom) {
        if (LibraryLoaded) {
            return DPLNewDestination(InstanceID, DestPage, Zoom, DestType, Left, Top, Right, Bottom);
        } else return 0;
    }

    public int NewDocument() {
        if (LibraryLoaded) {
            return DPLNewDocument(InstanceID);
        } else return 0;
    }

    public int NewFormField(String Title, int FieldType) {
        if (LibraryLoaded) {
            return DPLNewFormFieldA(InstanceID, Title, FieldType);
        } else return 0;
    }

    public int NewNamedDestination(String DestName, int DestID) {
        if (LibraryLoaded) {
            return DPLNewNamedDestinationA(InstanceID, DestName, DestID);
        } else return 0;
    }

    public int NewOptionalContentGroup(String GroupName) {
        if (LibraryLoaded) {
            return DPLNewOptionalContentGroupA(InstanceID, GroupName);
        } else return 0;
    }

    public int NewOutline(int Parent, String Title, int DestPage, double DestPosition) {
        if (LibraryLoaded) {
            return DPLNewOutlineA(InstanceID, Parent, Title, DestPage, DestPosition);
        } else return 0;
    }

    public int NewPage() {
        if (LibraryLoaded) {
            return DPLNewPage(InstanceID);
        } else return 0;
    }

    public int NewPages(int PageCount) {
        if (LibraryLoaded) {
            return DPLNewPages(InstanceID, PageCount);
        } else return 0;
    }

    public int NewPostScriptXObject(String PS) {
        if (LibraryLoaded) {
            return DPLNewPostScriptXObjectA(InstanceID, PS);
        } else return 0;
    }

    public int NewRGBAxialShader(String ShaderName, double StartX, double StartY, double StartRed, double StartGreen, double StartBlue, double EndX, double EndY, double EndRed, double EndGreen, double EndBlue, int Extend) {
        if (LibraryLoaded) {
            return DPLNewRGBAxialShaderA(InstanceID, ShaderName, StartX, StartY, StartRed, StartGreen, StartBlue, EndX, EndY, EndRed, EndGreen, EndBlue, Extend);
        } else return 0;
    }

    public int NewSignProcessFromFile(String InputFile, String Password) {
        if (LibraryLoaded) {
            return DPLNewSignProcessFromFileA(InstanceID, InputFile, Password);
        } else return 0;
    }

    public int NewSignProcessFromString(byte[] Source, String Password) {
        if (LibraryLoaded) {
            return DPLNewSignProcessFromStringA(InstanceID, Source, Password);
        } else return 0;
    }

    public int NewStaticOutline(int Parent, String Title) {
        if (LibraryLoaded) {
            return DPLNewStaticOutlineA(InstanceID, Parent, Title);
        } else return 0;
    }

    public int NewTilingPatternFromCapturedPage(String PatternName, int CaptureID) {
        if (LibraryLoaded) {
            return DPLNewTilingPatternFromCapturedPageA(InstanceID, PatternName, CaptureID);
        } else return 0;
    }

    public int NoEmbedFontListAdd(String FontName) {
        if (LibraryLoaded) {
            return DPLNoEmbedFontListAddA(InstanceID, FontName);
        } else return 0;
    }

    public int NoEmbedFontListCount() {
        if (LibraryLoaded) {
            return DPLNoEmbedFontListCount(InstanceID);
        } else return 0;
    }

    public String NoEmbedFontListGet(int Index) {
        if (LibraryLoaded) {
            return DPLNoEmbedFontListGetA(InstanceID, Index);
        } else return "";
    }

    public int NoEmbedFontListRemoveAll() {
        if (LibraryLoaded) {
            return DPLNoEmbedFontListRemoveAll(InstanceID);
        } else return 0;
    }

    public int NoEmbedFontListRemoveIndex(int Index) {
        if (LibraryLoaded) {
            return DPLNoEmbedFontListRemoveIndex(InstanceID, Index);
        } else return 0;
    }

    public int NoEmbedFontListRemoveName(String FontName) {
        if (LibraryLoaded) {
            return DPLNoEmbedFontListRemoveNameA(InstanceID, FontName);
        } else return 0;
    }

    public int NormalizePage(int NormalizeOptions) {
        if (LibraryLoaded) {
            return DPLNormalizePage(InstanceID, NormalizeOptions);
        } else return 0;
    }

    public int OpenOutline(int OutlineID) {
        if (LibraryLoaded) {
            return DPLOpenOutline(InstanceID, OutlineID);
        } else return 0;
    }

    public int OptionalContentGroupCount() {
        if (LibraryLoaded) {
            return DPLOptionalContentGroupCount(InstanceID);
        } else return 0;
    }

    public int OutlineCount() {
        if (LibraryLoaded) {
            return DPLOutlineCount(InstanceID);
        } else return 0;
    }

    public String OutlineTitle(int OutlineID) {
        if (LibraryLoaded) {
            return DPLOutlineTitleA(InstanceID, OutlineID);
        } else return "";
    }

    public int PageCount() {
        if (LibraryLoaded) {
            return DPLPageCount(InstanceID);
        } else return 0;
    }

    public int PageHasFontResources(int PageNumber) {
        if (LibraryLoaded) {
            return DPLPageHasFontResources(InstanceID, PageNumber);
        } else return 0;
    }

    public double PageHeight() {
        if (LibraryLoaded) {
            return DPLPageHeight(InstanceID);
        } else return 0;
    }

    public int PageJavaScriptAction(String ActionType, String JavaScript) {
        if (LibraryLoaded) {
            return DPLPageJavaScriptActionA(InstanceID, ActionType, JavaScript);
        } else return 0;
    }

    public int PageRotation() {
        if (LibraryLoaded) {
            return DPLPageRotation(InstanceID);
        } else return 0;
    }

    public double PageWidth() {
        if (LibraryLoaded) {
            return DPLPageWidth(InstanceID);
        } else return 0;
    }

    public int ReduceSize(int Options) {
        if (LibraryLoaded) {
            return DPLReduceSize(InstanceID, Options);
        } else return 0;
    }

    public int ReleaseImage(int ImageID) {
        if (LibraryLoaded) {
            return DPLReleaseImage(InstanceID, ImageID);
        } else return 0;
    }

    public int ReleaseImageList(int ImageListID) {
        if (LibraryLoaded) {
            return DPLReleaseImageList(InstanceID, ImageListID);
        } else return 0;
    }

    public int ReleaseSignProcess(int SignProcessID) {
        if (LibraryLoaded) {
            return DPLReleaseSignProcess(InstanceID, SignProcessID);
        } else return 0;
    }

    public int ReleaseStringList(int StringListID) {
        if (LibraryLoaded) {
            return DPLReleaseStringList(InstanceID, StringListID);
        } else return 0;
    }

    public int ReleaseTextBlocks(int TextBlockListID) {
        if (LibraryLoaded) {
            return DPLReleaseTextBlocks(InstanceID, TextBlockListID);
        } else return 0;
    }

    public int RemoveAppearanceStream(int Index) {
        if (LibraryLoaded) {
            return DPLRemoveAppearanceStream(InstanceID, Index);
        } else return 0;
    }

    public int RemoveCustomInformation(String Key) {
        if (LibraryLoaded) {
            return DPLRemoveCustomInformationA(InstanceID, Key);
        } else return 0;
    }

    public int RemoveDocument(int DocumentID) {
        if (LibraryLoaded) {
            return DPLRemoveDocument(InstanceID, DocumentID);
        } else return 0;
    }

    public int RemoveEmbeddedFile(int Index) {
        if (LibraryLoaded) {
            return DPLRemoveEmbeddedFile(InstanceID, Index);
        } else return 0;
    }

    public int RemoveFormFieldBackgroundColor(int Index) {
        if (LibraryLoaded) {
            return DPLRemoveFormFieldBackgroundColor(InstanceID, Index);
        } else return 0;
    }

    public int RemoveFormFieldBorderColor(int Index) {
        if (LibraryLoaded) {
            return DPLRemoveFormFieldBorderColor(InstanceID, Index);
        } else return 0;
    }

    public int RemoveFormFieldChoiceSub(int Index, String SubName) {
        if (LibraryLoaded) {
            return DPLRemoveFormFieldChoiceSubA(InstanceID, Index, SubName);
        } else return 0;
    }

    public int RemoveGlobalJavaScript(String PackageName) {
        if (LibraryLoaded) {
            return DPLRemoveGlobalJavaScriptA(InstanceID, PackageName);
        } else return 0;
    }

    public int RemoveOpenAction() {
        if (LibraryLoaded) {
            return DPLRemoveOpenAction(InstanceID);
        } else return 0;
    }

    public int RemoveOutline(int OutlineID) {
        if (LibraryLoaded) {
            return DPLRemoveOutline(InstanceID, OutlineID);
        } else return 0;
    }

    public int RemovePageBox(int BoxType) {
        if (LibraryLoaded) {
            return DPLRemovePageBox(InstanceID, BoxType);
        } else return 0;
    }

    public int RemoveSharedContentStreams() {
        if (LibraryLoaded) {
            return DPLRemoveSharedContentStreams(InstanceID);
        } else return 0;
    }

    public int RemoveStyle(String StyleName) {
        if (LibraryLoaded) {
            return DPLRemoveStyleA(InstanceID, StyleName);
        } else return 0;
    }

    public int RemoveUsageRights() {
        if (LibraryLoaded) {
            return DPLRemoveUsageRights(InstanceID);
        } else return 0;
    }

    public int RemoveXFAEntries(int Options) {
        if (LibraryLoaded) {
            return DPLRemoveXFAEntries(InstanceID, Options);
        } else return 0;
    }

    public int RenderAsMultipageTIFFToFile(double DPI, String PageRanges, int ImageOptions, int OutputOptions, String FileName) {
        if (LibraryLoaded) {
            return DPLRenderAsMultipageTIFFToFileA(InstanceID, DPI, PageRanges, ImageOptions, OutputOptions, FileName);
        } else return 0;
    }

    public int RenderDocumentToFile(double DPI, int StartPage, int EndPage, int Options, String FileName) {
        if (LibraryLoaded) {
            return DPLRenderDocumentToFileA(InstanceID, DPI, StartPage, EndPage, Options, FileName);
        } else return 0;
    }

    public int RenderPageToFile(double DPI, int Page, int Options, String FileName) {
        if (LibraryLoaded) {
            return DPLRenderPageToFileA(InstanceID, DPI, Page, Options, FileName);
        } else return 0;
    }

    public byte[] RenderPageToString(double DPI, int Page, int Options) {
        if (LibraryLoaded) {
            return DPLRenderPageToString(InstanceID, DPI, Page, Options);
        } else return new byte[0];
    }

    public int ReplaceFonts(int Options) {
        if (LibraryLoaded) {
            return DPLReplaceFonts(InstanceID, Options);
        } else return 0;
    }

    public int ReplaceImage(int OriginalImageID, int NewImageID) {
        if (LibraryLoaded) {
            return DPLReplaceImage(InstanceID, OriginalImageID, NewImageID);
        } else return 0;
    }

    public int ReplaceTag(String Tag, String NewValue) {
        if (LibraryLoaded) {
            return DPLReplaceTagA(InstanceID, Tag, NewValue);
        } else return 0;
    }

    public int RetrieveCustomDataToFile(String Key, String FileName, int Location) {
        if (LibraryLoaded) {
            return DPLRetrieveCustomDataToFileA(InstanceID, Key, FileName, Location);
        } else return 0;
    }

    public byte[] RetrieveCustomDataToString(String Key, int Location) {
        if (LibraryLoaded) {
            return DPLRetrieveCustomDataToStringA(InstanceID, Key, Location);
        } else return new byte[0];
    }

    public int ReverseImage(int Reset) {
        if (LibraryLoaded) {
            return DPLReverseImage(InstanceID, Reset);
        } else return 0;
    }

    public int RotatePage(int PageRotation) {
        if (LibraryLoaded) {
            return DPLRotatePage(InstanceID, PageRotation);
        } else return 0;
    }

    public int SaveFontToFile(String FileName) {
        if (LibraryLoaded) {
            return DPLSaveFontToFileA(InstanceID, FileName);
        } else return 0;
    }

    public int SaveImageListItemDataToFile(int ImageListID, int ImageIndex, int Options, String ImageFileName) {
        if (LibraryLoaded) {
            return DPLSaveImageListItemDataToFileA(InstanceID, ImageListID, ImageIndex, Options, ImageFileName);
        } else return 0;
    }

    public int SaveImageToFile(String FileName) {
        if (LibraryLoaded) {
            return DPLSaveImageToFileA(InstanceID, FileName);
        } else return 0;
    }

    public byte[] SaveImageToString() {
        if (LibraryLoaded) {
            return DPLSaveImageToString(InstanceID);
        } else return new byte[0];
    }

    public int SaveState() {
        if (LibraryLoaded) {
            return DPLSaveState(InstanceID);
        } else return 0;
    }

    public int SaveStyle(String StyleName) {
        if (LibraryLoaded) {
            return DPLSaveStyleA(InstanceID, StyleName);
        } else return 0;
    }

    public int SaveToFile(String FileName) {
        if (LibraryLoaded) {
            return DPLSaveToFileA(InstanceID, FileName);
        } else return 0;
    }

    public byte[] SaveToString() {
        if (LibraryLoaded) {
            return DPLSaveToString(InstanceID);
        } else return new byte[0];
    }

    public int SecurityInfo(int SecurityItem) {
        if (LibraryLoaded) {
            return DPLSecurityInfo(InstanceID, SecurityItem);
        } else return 0;
    }

    public int SelectContentStream(int NewIndex) {
        if (LibraryLoaded) {
            return DPLSelectContentStream(InstanceID, NewIndex);
        } else return 0;
    }

    public int SelectDocument(int DocumentID) {
        if (LibraryLoaded) {
            return DPLSelectDocument(InstanceID, DocumentID);
        } else return 0;
    }

    public int SelectFont(int FontID) {
        if (LibraryLoaded) {
            return DPLSelectFont(InstanceID, FontID);
        } else return 0;
    }

    public int SelectImage(int ImageID) {
        if (LibraryLoaded) {
            return DPLSelectImage(InstanceID, ImageID);
        } else return 0;
    }

    public int SelectPage(int PageNumber) {
        if (LibraryLoaded) {
            return DPLSelectPage(InstanceID, PageNumber);
        } else return 0;
    }

    public int SelectedDocument() {
        if (LibraryLoaded) {
            return DPLSelectedDocument(InstanceID);
        } else return 0;
    }

    public int SelectedFont() {
        if (LibraryLoaded) {
            return DPLSelectedFont(InstanceID);
        } else return 0;
    }

    public int SelectedImage() {
        if (LibraryLoaded) {
            return DPLSelectedImage(InstanceID);
        } else return 0;
    }

    public int SelectedPage() {
        if (LibraryLoaded) {
            return DPLSelectedPage(InstanceID);
        } else return 0;
    }

    public int SetActionURL(int ActionID, String NewURL) {
        if (LibraryLoaded) {
            return DPLSetActionURLA(InstanceID, ActionID, NewURL);
        } else return 0;
    }

    public int SetAnnotBorderColor(int Index, double Red, double Green, double Blue) {
        if (LibraryLoaded) {
            return DPLSetAnnotBorderColor(InstanceID, Index, Red, Green, Blue);
        } else return 0;
    }

    public int SetAnnotBorderStyle(int Index, double Width, int Style, double DashOn, double DashOff) {
        if (LibraryLoaded) {
            return DPLSetAnnotBorderStyle(InstanceID, Index, Width, Style, DashOn, DashOff);
        } else return 0;
    }

    public int SetAnnotContents(int Index, String NewContents) {
        if (LibraryLoaded) {
            return DPLSetAnnotContentsA(InstanceID, Index, NewContents);
        } else return 0;
    }

    public int SetAnnotDblProperty(int Index, int Tag, double NewValue) {
        if (LibraryLoaded) {
            return DPLSetAnnotDblProperty(InstanceID, Index, Tag, NewValue);
        } else return 0;
    }

    public int SetAnnotIntProperty(int Index, int Tag, int NewValue) {
        if (LibraryLoaded) {
            return DPLSetAnnotIntProperty(InstanceID, Index, Tag, NewValue);
        } else return 0;
    }

    public int SetAnnotOptional(int Index, int OptionalContentGroupID) {
        if (LibraryLoaded) {
            return DPLSetAnnotOptional(InstanceID, Index, OptionalContentGroupID);
        } else return 0;
    }

    public int SetAnnotQuadPoints(int Index, int QuadNumber, double X1, double Y1, double X2, double Y2, double X3, double Y3, double X4, double Y4) {
        if (LibraryLoaded) {
            return DPLSetAnnotQuadPoints(InstanceID, Index, QuadNumber, X1, Y1, X2, Y2, X3, Y3, X4, Y4);
        } else return 0;
    }

    public int SetAnnotRect(int Index, double Left, double Top, double Width, double Height) {
        if (LibraryLoaded) {
            return DPLSetAnnotRect(InstanceID, Index, Left, Top, Width, Height);
        } else return 0;
    }

    public int SetAnnotStrProperty(int Index, int Tag, String NewValue) {
        if (LibraryLoaded) {
            return DPLSetAnnotStrPropertyA(InstanceID, Index, Tag, NewValue);
        } else return 0;
    }

    public int SetAnsiMode(int NewAnsiMode) {
        if (LibraryLoaded) {
            return DPLSetAnsiMode(InstanceID, NewAnsiMode);
        } else return 0;
    }

    public int SetAppendInputFromString(byte[] Source) {
        if (LibraryLoaded) {
            return DPLSetAppendInputFromString(InstanceID, Source);
        } else return 0;
    }

    public int SetBaseURL(String NewBaseURL) {
        if (LibraryLoaded) {
            return DPLSetBaseURLA(InstanceID, NewBaseURL);
        } else return 0;
    }

    public int SetBlendMode(int BlendMode) {
        if (LibraryLoaded) {
            return DPLSetBlendMode(InstanceID, BlendMode);
        } else return 0;
    }

    public int SetBreakString(String NewBreakString) {
        if (LibraryLoaded) {
            return DPLSetBreakStringA(InstanceID, NewBreakString);
        } else return 0;
    }

    public int SetCSDictEPSG(int CSDictID, int NewEPSG) {
        if (LibraryLoaded) {
            return DPLSetCSDictEPSG(InstanceID, CSDictID, NewEPSG);
        } else return 0;
    }

    public int SetCSDictType(int CSDictID, int NewDictType) {
        if (LibraryLoaded) {
            return DPLSetCSDictType(InstanceID, CSDictID, NewDictType);
        } else return 0;
    }

    public int SetCSDictWKT(int CSDictID, String NewWKT) {
        if (LibraryLoaded) {
            return DPLSetCSDictWKTA(InstanceID, CSDictID, NewWKT);
        } else return 0;
    }

    public int SetCapturedPageOptional(int CaptureID, int OptionalContentGroupID) {
        if (LibraryLoaded) {
            return DPLSetCapturedPageOptional(InstanceID, CaptureID, OptionalContentGroupID);
        } else return 0;
    }

    public int SetCapturedPageTransparencyGroup(int CaptureID, int CS, int Isolate, int Knockout) {
        if (LibraryLoaded) {
            return DPLSetCapturedPageTransparencyGroup(InstanceID, CaptureID, CS, Isolate, Knockout);
        } else return 0;
    }

    public int SetCatalogInformation(String Key, String NewValue) {
        if (LibraryLoaded) {
            return DPLSetCatalogInformationA(InstanceID, Key, NewValue);
        } else return 0;
    }

    public int SetCharWidth(int CharCode, int NewWidth) {
        if (LibraryLoaded) {
            return DPLSetCharWidth(InstanceID, CharCode, NewWidth);
        } else return 0;
    }

    public int SetClippingPath() {
        if (LibraryLoaded) {
            return DPLSetClippingPath(InstanceID);
        } else return 0;
    }

    public int SetClippingPathEvenOdd() {
        if (LibraryLoaded) {
            return DPLSetClippingPathEvenOdd(InstanceID);
        } else return 0;
    }

    public int SetCompatibility(int CompatibilityItem, int CompatibilityMode) {
        if (LibraryLoaded) {
            return DPLSetCompatibility(InstanceID, CompatibilityItem, CompatibilityMode);
        } else return 0;
    }

    public int SetContentStreamFromString(byte[] Source) {
        if (LibraryLoaded) {
            return DPLSetContentStreamFromString(InstanceID, Source);
        } else return 0;
    }

    public int SetContentStreamOptional(int OptionalContentGroupID) {
        if (LibraryLoaded) {
            return DPLSetContentStreamOptional(InstanceID, OptionalContentGroupID);
        } else return 0;
    }

    public int SetCropBox(double Left, double Top, double Width, double Height) {
        if (LibraryLoaded) {
            return DPLSetCropBox(InstanceID, Left, Top, Width, Height);
        } else return 0;
    }

    public int SetCustomInformation(String Key, String NewValue) {
        if (LibraryLoaded) {
            return DPLSetCustomInformationA(InstanceID, Key, NewValue);
        } else return 0;
    }

    public int SetCustomLineDash(String DashPattern, double DashPhase) {
        if (LibraryLoaded) {
            return DPLSetCustomLineDashA(InstanceID, DashPattern, DashPhase);
        } else return 0;
    }

    public int SetDestProperties(int DestID, int Zoom, int DestType, double Left, double Top, double Right, double Bottom) {
        if (LibraryLoaded) {
            return DPLSetDestProperties(InstanceID, DestID, Zoom, DestType, Left, Top, Right, Bottom);
        } else return 0;
    }

    public int SetDestValue(int DestID, int ValueKey, double NewValue) {
        if (LibraryLoaded) {
            return DPLSetDestValue(InstanceID, DestID, ValueKey, NewValue);
        } else return 0;
    }

    public int SetDocumentMetadata(String XMP) {
        if (LibraryLoaded) {
            return DPLSetDocumentMetadataA(InstanceID, XMP);
        } else return 0;
    }

    public int SetEmbeddedFileStrProperty(int Index, int Tag, String NewValue) {
        if (LibraryLoaded) {
            return DPLSetEmbeddedFileStrPropertyA(InstanceID, Index, Tag, NewValue);
        } else return 0;
    }

    public int SetFillColor(double Red, double Green, double Blue) {
        if (LibraryLoaded) {
            return DPLSetFillColor(InstanceID, Red, Green, Blue);
        } else return 0;
    }

    public int SetFillColorCMYK(double C, double M, double Y, double K) {
        if (LibraryLoaded) {
            return DPLSetFillColorCMYK(InstanceID, C, M, Y, K);
        } else return 0;
    }

    public int SetFillColorSep(String ColorName, double Tint) {
        if (LibraryLoaded) {
            return DPLSetFillColorSepA(InstanceID, ColorName, Tint);
        } else return 0;
    }

    public int SetFillShader(String ShaderName) {
        if (LibraryLoaded) {
            return DPLSetFillShaderA(InstanceID, ShaderName);
        } else return 0;
    }

    public int SetFillTilingPattern(String PatternName) {
        if (LibraryLoaded) {
            return DPLSetFillTilingPatternA(InstanceID, PatternName);
        } else return 0;
    }

    public int SetFindImagesMode(int NewFindImagesMode) {
        if (LibraryLoaded) {
            return DPLSetFindImagesMode(InstanceID, NewFindImagesMode);
        } else return 0;
    }

    public int SetFontEncoding(int Encoding) {
        if (LibraryLoaded) {
            return DPLSetFontEncoding(InstanceID, Encoding);
        } else return 0;
    }

    public int SetFontFlags(int Fixed, int Serif, int Symbolic, int Script, int Italic, int AllCap, int SmallCap, int ForceBold) {
        if (LibraryLoaded) {
            return DPLSetFontFlags(InstanceID, Fixed, Serif, Symbolic, Script, Italic, AllCap, SmallCap, ForceBold);
        } else return 0;
    }

    public int SetFormFieldAlignment(int Index, int Alignment) {
        if (LibraryLoaded) {
            return DPLSetFormFieldAlignment(InstanceID, Index, Alignment);
        } else return 0;
    }

    public int SetFormFieldAnnotFlags(int Index, int NewFlags) {
        if (LibraryLoaded) {
            return DPLSetFormFieldAnnotFlags(InstanceID, Index, NewFlags);
        } else return 0;
    }

    public int SetFormFieldAppearanceFromString(int Index, byte[] Source, int FontID, String FontReference) {
        if (LibraryLoaded) {
            return DPLSetFormFieldAppearanceFromStringA(InstanceID, Index, Source, FontID, FontReference);
        } else return 0;
    }

    public int SetFormFieldBackgroundColor(int Index, double Red, double Green, double Blue) {
        if (LibraryLoaded) {
            return DPLSetFormFieldBackgroundColor(InstanceID, Index, Red, Green, Blue);
        } else return 0;
    }

    public int SetFormFieldBackgroundColorCMYK(int Index, double C, double M, double Y, double K) {
        if (LibraryLoaded) {
            return DPLSetFormFieldBackgroundColorCMYK(InstanceID, Index, C, M, Y, K);
        } else return 0;
    }

    public int SetFormFieldBackgroundColorGray(int Index, double Gray) {
        if (LibraryLoaded) {
            return DPLSetFormFieldBackgroundColorGray(InstanceID, Index, Gray);
        } else return 0;
    }

    public int SetFormFieldBackgroundColorSep(int Index, String ColorName, double Tint) {
        if (LibraryLoaded) {
            return DPLSetFormFieldBackgroundColorSepA(InstanceID, Index, ColorName, Tint);
        } else return 0;
    }

    public int SetFormFieldBorderColor(int Index, double Red, double Green, double Blue) {
        if (LibraryLoaded) {
            return DPLSetFormFieldBorderColor(InstanceID, Index, Red, Green, Blue);
        } else return 0;
    }

    public int SetFormFieldBorderColorCMYK(int Index, double C, double M, double Y, double K) {
        if (LibraryLoaded) {
            return DPLSetFormFieldBorderColorCMYK(InstanceID, Index, C, M, Y, K);
        } else return 0;
    }

    public int SetFormFieldBorderColorGray(int Index, double Gray) {
        if (LibraryLoaded) {
            return DPLSetFormFieldBorderColorGray(InstanceID, Index, Gray);
        } else return 0;
    }

    public int SetFormFieldBorderColorSep(int Index, String ColorName, double Tint) {
        if (LibraryLoaded) {
            return DPLSetFormFieldBorderColorSepA(InstanceID, Index, ColorName, Tint);
        } else return 0;
    }

    public int SetFormFieldBorderStyle(int Index, double Width, int Style, double DashOn, double DashOff) {
        if (LibraryLoaded) {
            return DPLSetFormFieldBorderStyle(InstanceID, Index, Width, Style, DashOn, DashOff);
        } else return 0;
    }

    public int SetFormFieldBounds(int Index, double Left, double Top, double Width, double Height) {
        if (LibraryLoaded) {
            return DPLSetFormFieldBounds(InstanceID, Index, Left, Top, Width, Height);
        } else return 0;
    }

    public int SetFormFieldCalcOrder(int Index, int Order) {
        if (LibraryLoaded) {
            return DPLSetFormFieldCalcOrder(InstanceID, Index, Order);
        } else return 0;
    }

    public int SetFormFieldCaption(int Index, String NewCaption) {
        if (LibraryLoaded) {
            return DPLSetFormFieldCaptionA(InstanceID, Index, NewCaption);
        } else return 0;
    }

    public int SetFormFieldCheckStyle(int Index, int CheckStyle, int Position) {
        if (LibraryLoaded) {
            return DPLSetFormFieldCheckStyle(InstanceID, Index, CheckStyle, Position);
        } else return 0;
    }

    public int SetFormFieldChildTitle(int Index, String NewTitle) {
        if (LibraryLoaded) {
            return DPLSetFormFieldChildTitleA(InstanceID, Index, NewTitle);
        } else return 0;
    }

    public int SetFormFieldChoiceSub(int Index, int SubIndex, String SubName, String DisplayName) {
        if (LibraryLoaded) {
            return DPLSetFormFieldChoiceSubA(InstanceID, Index, SubIndex, SubName, DisplayName);
        } else return 0;
    }

    public int SetFormFieldChoiceType(int Index, int ChoiceType) {
        if (LibraryLoaded) {
            return DPLSetFormFieldChoiceType(InstanceID, Index, ChoiceType);
        } else return 0;
    }

    public int SetFormFieldColor(int Index, double Red, double Green, double Blue) {
        if (LibraryLoaded) {
            return DPLSetFormFieldColor(InstanceID, Index, Red, Green, Blue);
        } else return 0;
    }

    public int SetFormFieldColorCMYK(int Index, double C, double M, double Y, double K) {
        if (LibraryLoaded) {
            return DPLSetFormFieldColorCMYK(InstanceID, Index, C, M, Y, K);
        } else return 0;
    }

    public int SetFormFieldColorSep(int Index, String ColorName, double Tint) {
        if (LibraryLoaded) {
            return DPLSetFormFieldColorSepA(InstanceID, Index, ColorName, Tint);
        } else return 0;
    }

    public int SetFormFieldComb(int Index, int Comb) {
        if (LibraryLoaded) {
            return DPLSetFormFieldComb(InstanceID, Index, Comb);
        } else return 0;
    }

    public int SetFormFieldCustomDict(int Index, String Key, String NewValue, int StorageType, int Options) {
        if (LibraryLoaded) {
            return DPLSetFormFieldCustomDictA(InstanceID, Index, Key, NewValue, StorageType, Options);
        } else return 0;
    }

    public int SetFormFieldDefaultValue(int Index, String NewDefaultValue) {
        if (LibraryLoaded) {
            return DPLSetFormFieldDefaultValueA(InstanceID, Index, NewDefaultValue);
        } else return 0;
    }

    public int SetFormFieldDefaultValueEx(int Index, String NewDefaultValue, int Options) {
        if (LibraryLoaded) {
            return DPLSetFormFieldDefaultValueExA(InstanceID, Index, NewDefaultValue, Options);
        } else return 0;
    }

    public int SetFormFieldDescription(int Index, String NewDescription) {
        if (LibraryLoaded) {
            return DPLSetFormFieldDescriptionA(InstanceID, Index, NewDescription);
        } else return 0;
    }

    public int SetFormFieldFlags(int Index, int NewFlags) {
        if (LibraryLoaded) {
            return DPLSetFormFieldFlags(InstanceID, Index, NewFlags);
        } else return 0;
    }

    public int SetFormFieldFont(int Index, int FontIndex) {
        if (LibraryLoaded) {
            return DPLSetFormFieldFont(InstanceID, Index, FontIndex);
        } else return 0;
    }

    public int SetFormFieldFormatMode(int NewFormatMode) {
        if (LibraryLoaded) {
            return DPLSetFormFieldFormatMode(InstanceID, NewFormatMode);
        } else return 0;
    }

    public int SetFormFieldHighlightMode(int Index, int NewMode) {
        if (LibraryLoaded) {
            return DPLSetFormFieldHighlightMode(InstanceID, Index, NewMode);
        } else return 0;
    }

    public int SetFormFieldIcon(int Index, int IconType, int CaptureID) {
        if (LibraryLoaded) {
            return DPLSetFormFieldIcon(InstanceID, Index, IconType, CaptureID);
        } else return 0;
    }

    public int SetFormFieldIconStyle(int Index, int Placement, int Scale, int ScaleType, int HorizontalShift, int VerticalShift) {
        if (LibraryLoaded) {
            return DPLSetFormFieldIconStyle(InstanceID, Index, Placement, Scale, ScaleType, HorizontalShift, VerticalShift);
        } else return 0;
    }

    public int SetFormFieldLockAction(int Index, int LockAction, String FieldList, String Delimiter) {
        if (LibraryLoaded) {
            return DPLSetFormFieldLockActionA(InstanceID, Index, LockAction, FieldList, Delimiter);
        } else return 0;
    }

    public int SetFormFieldMaxLen(int Index, int NewMaxLen) {
        if (LibraryLoaded) {
            return DPLSetFormFieldMaxLen(InstanceID, Index, NewMaxLen);
        } else return 0;
    }

    public int SetFormFieldMetadata(int Index, String XMP) {
        if (LibraryLoaded) {
            return DPLSetFormFieldMetadataA(InstanceID, Index, XMP);
        } else return 0;
    }

    public int SetFormFieldNoExport(int Index, int NoExport) {
        if (LibraryLoaded) {
            return DPLSetFormFieldNoExport(InstanceID, Index, NoExport);
        } else return 0;
    }

    public int SetFormFieldOptional(int Index, int OptionalContentGroupID) {
        if (LibraryLoaded) {
            return DPLSetFormFieldOptional(InstanceID, Index, OptionalContentGroupID);
        } else return 0;
    }

    public int SetFormFieldPage(int Index, int NewPage) {
        if (LibraryLoaded) {
            return DPLSetFormFieldPage(InstanceID, Index, NewPage);
        } else return 0;
    }

    public int SetFormFieldPrintable(int Index, int Printable) {
        if (LibraryLoaded) {
            return DPLSetFormFieldPrintable(InstanceID, Index, Printable);
        } else return 0;
    }

    public int SetFormFieldReadOnly(int Index, int ReadOnly) {
        if (LibraryLoaded) {
            return DPLSetFormFieldReadOnly(InstanceID, Index, ReadOnly);
        } else return 0;
    }

    public int SetFormFieldRequired(int Index, int Required) {
        if (LibraryLoaded) {
            return DPLSetFormFieldRequired(InstanceID, Index, Required);
        } else return 0;
    }

    public int SetFormFieldResetAction(int Index, String ActionType) {
        if (LibraryLoaded) {
            return DPLSetFormFieldResetActionA(InstanceID, Index, ActionType);
        } else return 0;
    }

    public int SetFormFieldRichTextString(int Index, String Key, String NewValue) {
        if (LibraryLoaded) {
            return DPLSetFormFieldRichTextStringA(InstanceID, Index, Key, NewValue);
        } else return 0;
    }

    public int SetFormFieldRotation(int Index, int Angle) {
        if (LibraryLoaded) {
            return DPLSetFormFieldRotation(InstanceID, Index, Angle);
        } else return 0;
    }

    public int SetFormFieldSignatureImage(int Index, int ImageID, int Options) {
        if (LibraryLoaded) {
            return DPLSetFormFieldSignatureImage(InstanceID, Index, ImageID, Options);
        } else return 0;
    }

    public int SetFormFieldStandardFont(int Index, int StandardFontID) {
        if (LibraryLoaded) {
            return DPLSetFormFieldStandardFont(InstanceID, Index, StandardFontID);
        } else return 0;
    }

    public int SetFormFieldSubmitAction(int Index, String ActionType, String Link) {
        if (LibraryLoaded) {
            return DPLSetFormFieldSubmitActionA(InstanceID, Index, ActionType, Link);
        } else return 0;
    }

    public int SetFormFieldSubmitActionEx(int Index, String ActionType, String Link, int Flags) {
        if (LibraryLoaded) {
            return DPLSetFormFieldSubmitActionExA(InstanceID, Index, ActionType, Link, Flags);
        } else return 0;
    }

    public int SetFormFieldTabOrder(int Index, int Order) {
        if (LibraryLoaded) {
            return DPLSetFormFieldTabOrder(InstanceID, Index, Order);
        } else return 0;
    }

    public int SetFormFieldTextFlags(int Index, int Multiline, int Password, int FileSelect, int DoNotSpellCheck, int DoNotScroll) {
        if (LibraryLoaded) {
            return DPLSetFormFieldTextFlags(InstanceID, Index, Multiline, Password, FileSelect, DoNotSpellCheck, DoNotScroll);
        } else return 0;
    }

    public int SetFormFieldTextSize(int Index, double NewTextSize) {
        if (LibraryLoaded) {
            return DPLSetFormFieldTextSize(InstanceID, Index, NewTextSize);
        } else return 0;
    }

    public int SetFormFieldTitle(int Index, String NewTitle) {
        if (LibraryLoaded) {
            return DPLSetFormFieldTitleA(InstanceID, Index, NewTitle);
        } else return 0;
    }

    public int SetFormFieldValue(int Index, String NewValue) {
        if (LibraryLoaded) {
            return DPLSetFormFieldValueA(InstanceID, Index, NewValue);
        } else return 0;
    }

    public int SetFormFieldValueByTitle(String Title, String NewValue) {
        if (LibraryLoaded) {
            return DPLSetFormFieldValueByTitleA(InstanceID, Title, NewValue);
        } else return 0;
    }

    public int SetFormFieldValueEx(int Index, String NewValue, int Options) {
        if (LibraryLoaded) {
            return DPLSetFormFieldValueExA(InstanceID, Index, NewValue, Options);
        } else return 0;
    }

    public int SetFormFieldVisible(int Index, int Visible) {
        if (LibraryLoaded) {
            return DPLSetFormFieldVisible(InstanceID, Index, Visible);
        } else return 0;
    }

    public int SetHTMLBoldFont(String FontSet, int FontID) {
        if (LibraryLoaded) {
            return DPLSetHTMLBoldFontA(InstanceID, FontSet, FontID);
        } else return 0;
    }

    public int SetHTMLBoldItalicFont(String FontSet, int FontID) {
        if (LibraryLoaded) {
            return DPLSetHTMLBoldItalicFontA(InstanceID, FontSet, FontID);
        } else return 0;
    }

    public int SetHTMLItalicFont(String FontSet, int FontID) {
        if (LibraryLoaded) {
            return DPLSetHTMLItalicFontA(InstanceID, FontSet, FontID);
        } else return 0;
    }

    public int SetHTMLNormalFont(String FontSet, int FontID) {
        if (LibraryLoaded) {
            return DPLSetHTMLNormalFontA(InstanceID, FontSet, FontID);
        } else return 0;
    }

    public int SetHeaderCommentsFromString(byte[] Source) {
        if (LibraryLoaded) {
            return DPLSetHeaderCommentsFromString(InstanceID, Source);
        } else return 0;
    }

    public int SetImageAsMask(int MaskType) {
        if (LibraryLoaded) {
            return DPLSetImageAsMask(InstanceID, MaskType);
        } else return 0;
    }

    public int SetImageMask(double FromRed, double FromGreen, double FromBlue, double ToRed, double ToGreen, double ToBlue) {
        if (LibraryLoaded) {
            return DPLSetImageMask(InstanceID, FromRed, FromGreen, FromBlue, ToRed, ToGreen, ToBlue);
        } else return 0;
    }

    public int SetImageMaskCMYK(double FromC, double FromM, double FromY, double FromK, double ToC, double ToM, double ToY, double ToK) {
        if (LibraryLoaded) {
            return DPLSetImageMaskCMYK(InstanceID, FromC, FromM, FromY, FromK, ToC, ToM, ToY, ToK);
        } else return 0;
    }

    public int SetImageMaskFromImage(int ImageID) {
        if (LibraryLoaded) {
            return DPLSetImageMaskFromImage(InstanceID, ImageID);
        } else return 0;
    }

    public int SetImageOptional(int OptionalContentGroupID) {
        if (LibraryLoaded) {
            return DPLSetImageOptional(InstanceID, OptionalContentGroupID);
        } else return 0;
    }

    public int SetImageResolution(int Horizontal, int Vertical, int Units) {
        if (LibraryLoaded) {
            return DPLSetImageResolution(InstanceID, Horizontal, Vertical, Units);
        } else return 0;
    }

    public int SetInformation(int Key, String NewValue) {
        if (LibraryLoaded) {
            return DPLSetInformationA(InstanceID, Key, NewValue);
        } else return 0;
    }

    public int SetJPEGQuality(int Quality) {
        if (LibraryLoaded) {
            return DPLSetJPEGQuality(InstanceID, Quality);
        } else return 0;
    }

    public int SetJavaScriptMode(int JSMode) {
        if (LibraryLoaded) {
            return DPLSetJavaScriptMode(InstanceID, JSMode);
        } else return 0;
    }

    public int SetKerning(String CharPair, int Adjustment) {
        if (LibraryLoaded) {
            return DPLSetKerningA(InstanceID, CharPair, Adjustment);
        } else return 0;
    }

    public int SetLineCap(int LineCap) {
        if (LibraryLoaded) {
            return DPLSetLineCap(InstanceID, LineCap);
        } else return 0;
    }

    public int SetLineColor(double Red, double Green, double Blue) {
        if (LibraryLoaded) {
            return DPLSetLineColor(InstanceID, Red, Green, Blue);
        } else return 0;
    }

    public int SetLineColorCMYK(double C, double M, double Y, double K) {
        if (LibraryLoaded) {
            return DPLSetLineColorCMYK(InstanceID, C, M, Y, K);
        } else return 0;
    }

    public int SetLineColorSep(String ColorName, double Tint) {
        if (LibraryLoaded) {
            return DPLSetLineColorSepA(InstanceID, ColorName, Tint);
        } else return 0;
    }

    public int SetLineDash(double DashOn, double DashOff) {
        if (LibraryLoaded) {
            return DPLSetLineDash(InstanceID, DashOn, DashOff);
        } else return 0;
    }

    public int SetLineDashEx(String DashValues) {
        if (LibraryLoaded) {
            return DPLSetLineDashExA(InstanceID, DashValues);
        } else return 0;
    }

    public int SetLineJoin(int LineJoin) {
        if (LibraryLoaded) {
            return DPLSetLineJoin(InstanceID, LineJoin);
        } else return 0;
    }

    public int SetLineShader(String ShaderName) {
        if (LibraryLoaded) {
            return DPLSetLineShaderA(InstanceID, ShaderName);
        } else return 0;
    }

    public int SetLineWidth(double LineWidth) {
        if (LibraryLoaded) {
            return DPLSetLineWidth(InstanceID, LineWidth);
        } else return 0;
    }

    public int SetMarkupAnnotStyle(int Index, double Red, double Green, double Blue, double Transparency) {
        if (LibraryLoaded) {
            return DPLSetMarkupAnnotStyle(InstanceID, Index, Red, Green, Blue, Transparency);
        } else return 0;
    }

    public int SetMeasureDictBoundsCount(int MeasureDictID, int NewCount) {
        if (LibraryLoaded) {
            return DPLSetMeasureDictBoundsCount(InstanceID, MeasureDictID, NewCount);
        } else return 0;
    }

    public int SetMeasureDictBoundsItem(int MeasureDictID, int ItemIndex, double NewValue) {
        if (LibraryLoaded) {
            return DPLSetMeasureDictBoundsItem(InstanceID, MeasureDictID, ItemIndex, NewValue);
        } else return 0;
    }

    public int SetMeasureDictCoordinateSystem(int MeasureDictID, int CoordinateSystemID) {
        if (LibraryLoaded) {
            return DPLSetMeasureDictCoordinateSystem(InstanceID, MeasureDictID, CoordinateSystemID);
        } else return 0;
    }

    public int SetMeasureDictGPTSCount(int MeasureDictID, int NewCount) {
        if (LibraryLoaded) {
            return DPLSetMeasureDictGPTSCount(InstanceID, MeasureDictID, NewCount);
        } else return 0;
    }

    public int SetMeasureDictGPTSItem(int MeasureDictID, int ItemIndex, double NewValue) {
        if (LibraryLoaded) {
            return DPLSetMeasureDictGPTSItem(InstanceID, MeasureDictID, ItemIndex, NewValue);
        } else return 0;
    }

    public int SetMeasureDictLPTSCount(int MeasureDictID, int NewCount) {
        if (LibraryLoaded) {
            return DPLSetMeasureDictLPTSCount(InstanceID, MeasureDictID, NewCount);
        } else return 0;
    }

    public int SetMeasureDictLPTSItem(int MeasureDictID, int ItemIndex, double NewValue) {
        if (LibraryLoaded) {
            return DPLSetMeasureDictLPTSItem(InstanceID, MeasureDictID, ItemIndex, NewValue);
        } else return 0;
    }

    public int SetMeasureDictPDU(int MeasureDictID, int LinearUnit, int AreaUnit, int AngularUnit) {
        if (LibraryLoaded) {
            return DPLSetMeasureDictPDU(InstanceID, MeasureDictID, LinearUnit, AreaUnit, AngularUnit);
        } else return 0;
    }

    public int SetMeasurementUnits(int MeasurementUnits) {
        if (LibraryLoaded) {
            return DPLSetMeasurementUnits(InstanceID, MeasurementUnits);
        } else return 0;
    }

    public int SetNeedAppearances(int NewValue) {
        if (LibraryLoaded) {
            return DPLSetNeedAppearances(InstanceID, NewValue);
        } else return 0;
    }

    public int SetObjectFromString(int ObjectNumber, byte[] Source) {
        if (LibraryLoaded) {
            return DPLSetObjectFromString(InstanceID, ObjectNumber, Source);
        } else return 0;
    }

    public int SetOpenActionDestination(int OpenPage, int Zoom) {
        if (LibraryLoaded) {
            return DPLSetOpenActionDestination(InstanceID, OpenPage, Zoom);
        } else return 0;
    }

    public int SetOpenActionDestinationFull(int OpenPage, int Zoom, int DestType, double Left, double Top, double Right, double Bottom) {
        if (LibraryLoaded) {
            return DPLSetOpenActionDestinationFull(InstanceID, OpenPage, Zoom, DestType, Left, Top, Right, Bottom);
        } else return 0;
    }

    public int SetOpenActionJavaScript(String JavaScript) {
        if (LibraryLoaded) {
            return DPLSetOpenActionJavaScriptA(InstanceID, JavaScript);
        } else return 0;
    }

    public int SetOpenActionMenu(String MenuItem) {
        if (LibraryLoaded) {
            return DPLSetOpenActionMenuA(InstanceID, MenuItem);
        } else return 0;
    }

    public int SetOptionalContentConfigLocked(int OptionalContentConfigID, int OptionalContentGroupID, int NewLocked) {
        if (LibraryLoaded) {
            return DPLSetOptionalContentConfigLocked(InstanceID, OptionalContentConfigID, OptionalContentGroupID, NewLocked);
        } else return 0;
    }

    public int SetOptionalContentConfigState(int OptionalContentConfigID, int OptionalContentGroupID, int NewState) {
        if (LibraryLoaded) {
            return DPLSetOptionalContentConfigState(InstanceID, OptionalContentConfigID, OptionalContentGroupID, NewState);
        } else return 0;
    }

    public int SetOptionalContentGroupName(int OptionalContentGroupID, String NewGroupName) {
        if (LibraryLoaded) {
            return DPLSetOptionalContentGroupNameA(InstanceID, OptionalContentGroupID, NewGroupName);
        } else return 0;
    }

    public int SetOptionalContentGroupPrintable(int OptionalContentGroupID, int Printable) {
        if (LibraryLoaded) {
            return DPLSetOptionalContentGroupPrintable(InstanceID, OptionalContentGroupID, Printable);
        } else return 0;
    }

    public int SetOptionalContentGroupVisible(int OptionalContentGroupID, int Visible) {
        if (LibraryLoaded) {
            return DPLSetOptionalContentGroupVisible(InstanceID, OptionalContentGroupID, Visible);
        } else return 0;
    }

    public int SetOrigin(int Origin) {
        if (LibraryLoaded) {
            return DPLSetOrigin(InstanceID, Origin);
        } else return 0;
    }

    public int SetOutlineColor(int OutlineID, double Red, double Green, double Blue) {
        if (LibraryLoaded) {
            return DPLSetOutlineColor(InstanceID, OutlineID, Red, Green, Blue);
        } else return 0;
    }

    public int SetOutlineDestination(int OutlineID, int DestPage, double DestPosition) {
        if (LibraryLoaded) {
            return DPLSetOutlineDestination(InstanceID, OutlineID, DestPage, DestPosition);
        } else return 0;
    }

    public int SetOutlineDestinationFull(int OutlineID, int DestPage, int Zoom, int DestType, double Left, double Top, double Right, double Bottom) {
        if (LibraryLoaded) {
            return DPLSetOutlineDestinationFull(InstanceID, OutlineID, DestPage, Zoom, DestType, Left, Top, Right, Bottom);
        } else return 0;
    }

    public int SetOutlineDestinationZoom(int OutlineID, int DestPage, double DestPosition, int Zoom) {
        if (LibraryLoaded) {
            return DPLSetOutlineDestinationZoom(InstanceID, OutlineID, DestPage, DestPosition, Zoom);
        } else return 0;
    }

    public int SetOutlineJavaScript(int OutlineID, String JavaScript) {
        if (LibraryLoaded) {
            return DPLSetOutlineJavaScriptA(InstanceID, OutlineID, JavaScript);
        } else return 0;
    }

    public int SetOutlineNamedDestination(int OutlineID, String DestName) {
        if (LibraryLoaded) {
            return DPLSetOutlineNamedDestinationA(InstanceID, OutlineID, DestName);
        } else return 0;
    }

    public int SetOutlineOpenFile(int OutlineID, String FileName) {
        if (LibraryLoaded) {
            return DPLSetOutlineOpenFileA(InstanceID, OutlineID, FileName);
        } else return 0;
    }

    public int SetOutlineRemoteDestination(int OutlineID, String FileName, int OpenPage, int Zoom, int DestType, double PntLeft, double PntTop, double PntRight, double PntBottom, int NewWindow) {
        if (LibraryLoaded) {
            return DPLSetOutlineRemoteDestinationA(InstanceID, OutlineID, FileName, OpenPage, Zoom, DestType, PntLeft, PntTop, PntRight, PntBottom, NewWindow);
        } else return 0;
    }

    public int SetOutlineStyle(int OutlineID, int SetItalic, int SetBold) {
        if (LibraryLoaded) {
            return DPLSetOutlineStyle(InstanceID, OutlineID, SetItalic, SetBold);
        } else return 0;
    }

    public int SetOutlineTitle(int OutlineID, String NewTitle) {
        if (LibraryLoaded) {
            return DPLSetOutlineTitleA(InstanceID, OutlineID, NewTitle);
        } else return 0;
    }

    public int SetOutlineWebLink(int OutlineID, String Link) {
        if (LibraryLoaded) {
            return DPLSetOutlineWebLinkA(InstanceID, OutlineID, Link);
        } else return 0;
    }

    public int SetOverprint(int StrokingOverprint, int OtherOverprint, int OverprintMode) {
        if (LibraryLoaded) {
            return DPLSetOverprint(InstanceID, StrokingOverprint, OtherOverprint, OverprintMode);
        } else return 0;
    }

    public int SetPDFAMode(int NewMode) {
        if (LibraryLoaded) {
            return DPLSetPDFAMode(InstanceID, NewMode);
        } else return 0;
    }

    public int SetPNGTransparencyColor(int RedByte, int GreenByte, int BlueByte) {
        if (LibraryLoaded) {
            return DPLSetPNGTransparencyColor(InstanceID, RedByte, GreenByte, BlueByte);
        } else return 0;
    }

    public int SetPageActionMenu(String MenuItem) {
        if (LibraryLoaded) {
            return DPLSetPageActionMenuA(InstanceID, MenuItem);
        } else return 0;
    }

    public int SetPageBox(int BoxType, double Left, double Top, double Width, double Height) {
        if (LibraryLoaded) {
            return DPLSetPageBox(InstanceID, BoxType, Left, Top, Width, Height);
        } else return 0;
    }

    public int SetPageContentFromString(byte[] Source) {
        if (LibraryLoaded) {
            return DPLSetPageContentFromString(InstanceID, Source);
        } else return 0;
    }

    public int SetPageDimensions(double NewPageWidth, double NewPageHeight) {
        if (LibraryLoaded) {
            return DPLSetPageDimensions(InstanceID, NewPageWidth, NewPageHeight);
        } else return 0;
    }

    public int SetPageLayout(int NewPageLayout) {
        if (LibraryLoaded) {
            return DPLSetPageLayout(InstanceID, NewPageLayout);
        } else return 0;
    }

    public int SetPageMetadata(String XMP) {
        if (LibraryLoaded) {
            return DPLSetPageMetadataA(InstanceID, XMP);
        } else return 0;
    }

    public int SetPageMode(int NewPageMode) {
        if (LibraryLoaded) {
            return DPLSetPageMode(InstanceID, NewPageMode);
        } else return 0;
    }

    public int SetPageSize(String PaperName) {
        if (LibraryLoaded) {
            return DPLSetPageSizeA(InstanceID, PaperName);
        } else return 0;
    }

    public int SetPageThumbnail() {
        if (LibraryLoaded) {
            return DPLSetPageThumbnail(InstanceID);
        } else return 0;
    }

    public int SetPageTransparencyGroup(int CS, int Isolate, int Knockout) {
        if (LibraryLoaded) {
            return DPLSetPageTransparencyGroup(InstanceID, CS, Isolate, Knockout);
        } else return 0;
    }

    public int SetPageUserUnit(double UserUnit) {
        if (LibraryLoaded) {
            return DPLSetPageUserUnit(InstanceID, UserUnit);
        } else return 0;
    }

    public int SetPrecision(int NewPrecision) {
        if (LibraryLoaded) {
            return DPLSetPrecision(InstanceID, NewPrecision);
        } else return 0;
    }

    public int SetRenderArea(double Left, double Top, double Width, double Height) {
        if (LibraryLoaded) {
            return DPLSetRenderArea(InstanceID, Left, Top, Width, Height);
        } else return 0;
    }

    public int SetRenderCropType(int NewCropType) {
        if (LibraryLoaded) {
            return DPLSetRenderCropType(InstanceID, NewCropType);
        } else return 0;
    }

    public int SetRenderOptions(int OptionID, int NewValue) {
        if (LibraryLoaded) {
            return DPLSetRenderOptions(InstanceID, OptionID, NewValue);
        } else return 0;
    }

    public int SetRenderScale(double NewScale) {
        if (LibraryLoaded) {
            return DPLSetRenderScale(InstanceID, NewScale);
        } else return 0;
    }

    public int SetScale(double NewScale) {
        if (LibraryLoaded) {
            return DPLSetScale(InstanceID, NewScale);
        } else return 0;
    }

    public int SetSignProcessAppearanceFromString(int SignProcessID, String LayerName, byte[] Source) {
        if (LibraryLoaded) {
            return DPLSetSignProcessAppearanceFromStringA(InstanceID, SignProcessID, LayerName, Source);
        } else return 0;
    }

    public int SetSignProcessCustomDict(int SignProcessID, String Key, String NewValue, int StorageType) {
        if (LibraryLoaded) {
            return DPLSetSignProcessCustomDictA(InstanceID, SignProcessID, Key, NewValue, StorageType);
        } else return 0;
    }

    public int SetSignProcessCustomSubFilter(int SignProcessID, String SubFilterStr) {
        if (LibraryLoaded) {
            return DPLSetSignProcessCustomSubFilterA(InstanceID, SignProcessID, SubFilterStr);
        } else return 0;
    }

    public int SetSignProcessField(int SignProcessID, String SignatureFieldName) {
        if (LibraryLoaded) {
            return DPLSetSignProcessFieldA(InstanceID, SignProcessID, SignatureFieldName);
        } else return 0;
    }

    public int SetSignProcessFieldBounds(int SignProcessID, double Left, double Top, double Width, double Height) {
        if (LibraryLoaded) {
            return DPLSetSignProcessFieldBounds(InstanceID, SignProcessID, Left, Top, Width, Height);
        } else return 0;
    }

    public int SetSignProcessFieldImageFromFile(int SignProcessID, String ImageFileName, int Options) {
        if (LibraryLoaded) {
            return DPLSetSignProcessFieldImageFromFileA(InstanceID, SignProcessID, ImageFileName, Options);
        } else return 0;
    }

    public int SetSignProcessFieldImageFromString(int SignProcessID, byte[] Source, int Options) {
        if (LibraryLoaded) {
            return DPLSetSignProcessFieldImageFromString(InstanceID, SignProcessID, Source, Options);
        } else return 0;
    }

    public int SetSignProcessFieldLocked(int SignProcessID, int LockFieldAfterSign) {
        if (LibraryLoaded) {
            return DPLSetSignProcessFieldLocked(InstanceID, SignProcessID, LockFieldAfterSign);
        } else return 0;
    }

    public int SetSignProcessFieldMetadata(int SignProcessID, String XMP) {
        if (LibraryLoaded) {
            return DPLSetSignProcessFieldMetadataA(InstanceID, SignProcessID, XMP);
        } else return 0;
    }

    public int SetSignProcessFieldPage(int SignProcessID, int SignaturePage) {
        if (LibraryLoaded) {
            return DPLSetSignProcessFieldPage(InstanceID, SignProcessID, SignaturePage);
        } else return 0;
    }

    public int SetSignProcessImageLayer(int SignProcessID, String LayerName) {
        if (LibraryLoaded) {
            return DPLSetSignProcessImageLayerA(InstanceID, SignProcessID, LayerName);
        } else return 0;
    }

    public int SetSignProcessInfo(int SignProcessID, String Reason, String Location, String ContactInfo) {
        if (LibraryLoaded) {
            return DPLSetSignProcessInfoA(InstanceID, SignProcessID, Reason, Location, ContactInfo);
        } else return 0;
    }

    public int SetSignProcessKeyset(int SignProcessID, int KeysetID) {
        if (LibraryLoaded) {
            return DPLSetSignProcessKeyset(InstanceID, SignProcessID, KeysetID);
        } else return 0;
    }

    public int SetSignProcessOptions(int SignProcessID, int OptionID, int OptionValue) {
        if (LibraryLoaded) {
            return DPLSetSignProcessOptions(InstanceID, SignProcessID, OptionID, OptionValue);
        } else return 0;
    }

    public int SetSignProcessPFXFromFile(int SignProcessID, String PFXFileName, String PFXPassword) {
        if (LibraryLoaded) {
            return DPLSetSignProcessPFXFromFileA(InstanceID, SignProcessID, PFXFileName, PFXPassword);
        } else return 0;
    }

    public int SetSignProcessPFXFromString(int SignProcessID, byte[] Source, String PFXPassword) {
        if (LibraryLoaded) {
            return DPLSetSignProcessPFXFromStringA(InstanceID, SignProcessID, Source, PFXPassword);
        } else return 0;
    }

    public int SetSignProcessPassthrough(int SignProcessID, int SignatureLength) {
        if (LibraryLoaded) {
            return DPLSetSignProcessPassthrough(InstanceID, SignProcessID, SignatureLength);
        } else return 0;
    }

    public int SetSignProcessSubFilter(int SignProcessID, int SubFilter) {
        if (LibraryLoaded) {
            return DPLSetSignProcessSubFilter(InstanceID, SignProcessID, SubFilter);
        } else return 0;
    }

    public int SetTabOrderMode(String Mode) {
        if (LibraryLoaded) {
            return DPLSetTabOrderModeA(InstanceID, Mode);
        } else return 0;
    }

    public int SetTableBorderColor(int TableID, int BorderIndex, double Red, double Green, double Blue) {
        if (LibraryLoaded) {
            return DPLSetTableBorderColor(InstanceID, TableID, BorderIndex, Red, Green, Blue);
        } else return 0;
    }

    public int SetTableBorderColorCMYK(int TableID, int BorderIndex, double C, double M, double Y, double K) {
        if (LibraryLoaded) {
            return DPLSetTableBorderColorCMYK(InstanceID, TableID, BorderIndex, C, M, Y, K);
        } else return 0;
    }

    public int SetTableBorderWidth(int TableID, int BorderIndex, double NewWidth) {
        if (LibraryLoaded) {
            return DPLSetTableBorderWidth(InstanceID, TableID, BorderIndex, NewWidth);
        } else return 0;
    }

    public int SetTableCellAlignment(int TableID, int FirstRow, int FirstColumn, int LastRow, int LastColumn, int NewCellAlignment) {
        if (LibraryLoaded) {
            return DPLSetTableCellAlignment(InstanceID, TableID, FirstRow, FirstColumn, LastRow, LastColumn, NewCellAlignment);
        } else return 0;
    }

    public int SetTableCellBackgroundColor(int TableID, int FirstRow, int FirstColumn, int LastRow, int LastColumn, double Red, double Green, double Blue) {
        if (LibraryLoaded) {
            return DPLSetTableCellBackgroundColor(InstanceID, TableID, FirstRow, FirstColumn, LastRow, LastColumn, Red, Green, Blue);
        } else return 0;
    }

    public int SetTableCellBackgroundColorCMYK(int TableID, int FirstRow, int FirstColumn, int LastRow, int LastColumn, double C, double M, double Y, double K) {
        if (LibraryLoaded) {
            return DPLSetTableCellBackgroundColorCMYK(InstanceID, TableID, FirstRow, FirstColumn, LastRow, LastColumn, C, M, Y, K);
        } else return 0;
    }

    public int SetTableCellBorderColor(int TableID, int FirstRow, int FirstColumn, int LastRow, int LastColumn, int BorderIndex, double Red, double Green, double Blue) {
        if (LibraryLoaded) {
            return DPLSetTableCellBorderColor(InstanceID, TableID, FirstRow, FirstColumn, LastRow, LastColumn, BorderIndex, Red, Green, Blue);
        } else return 0;
    }

    public int SetTableCellBorderColorCMYK(int TableID, int FirstRow, int FirstColumn, int LastRow, int LastColumn, int BorderIndex, double C, double M, double Y, double K) {
        if (LibraryLoaded) {
            return DPLSetTableCellBorderColorCMYK(InstanceID, TableID, FirstRow, FirstColumn, LastRow, LastColumn, BorderIndex, C, M, Y, K);
        } else return 0;
    }

    public int SetTableCellBorderWidth(int TableID, int FirstRow, int FirstColumn, int LastRow, int LastColumn, int BorderIndex, double NewWidth) {
        if (LibraryLoaded) {
            return DPLSetTableCellBorderWidth(InstanceID, TableID, FirstRow, FirstColumn, LastRow, LastColumn, BorderIndex, NewWidth);
        } else return 0;
    }

    public int SetTableCellContent(int TableID, int RowNumber, int ColumnNumber, String HTMLText) {
        if (LibraryLoaded) {
            return DPLSetTableCellContentA(InstanceID, TableID, RowNumber, ColumnNumber, HTMLText);
        } else return 0;
    }

    public int SetTableCellPadding(int TableID, int FirstRow, int FirstColumn, int LastRow, int LastColumn, int BorderIndex, double NewPadding) {
        if (LibraryLoaded) {
            return DPLSetTableCellPadding(InstanceID, TableID, FirstRow, FirstColumn, LastRow, LastColumn, BorderIndex, NewPadding);
        } else return 0;
    }

    public int SetTableCellTextColor(int TableID, int FirstRow, int FirstColumn, int LastRow, int LastColumn, double Red, double Green, double Blue) {
        if (LibraryLoaded) {
            return DPLSetTableCellTextColor(InstanceID, TableID, FirstRow, FirstColumn, LastRow, LastColumn, Red, Green, Blue);
        } else return 0;
    }

    public int SetTableCellTextColorCMYK(int TableID, int FirstRow, int FirstColumn, int LastRow, int LastColumn, double C, double M, double Y, double K) {
        if (LibraryLoaded) {
            return DPLSetTableCellTextColorCMYK(InstanceID, TableID, FirstRow, FirstColumn, LastRow, LastColumn, C, M, Y, K);
        } else return 0;
    }

    public int SetTableCellTextSize(int TableID, int FirstRow, int FirstColumn, int LastRow, int LastColumn, double NewTextSize) {
        if (LibraryLoaded) {
            return DPLSetTableCellTextSize(InstanceID, TableID, FirstRow, FirstColumn, LastRow, LastColumn, NewTextSize);
        } else return 0;
    }

    public int SetTableColumnWidth(int TableID, int FirstColumn, int LastColumn, double NewWidth) {
        if (LibraryLoaded) {
            return DPLSetTableColumnWidth(InstanceID, TableID, FirstColumn, LastColumn, NewWidth);
        } else return 0;
    }

    public int SetTableRowHeight(int TableID, int FirstRow, int LastRow, double NewHeight) {
        if (LibraryLoaded) {
            return DPLSetTableRowHeight(InstanceID, TableID, FirstRow, LastRow, NewHeight);
        } else return 0;
    }

    public int SetTableThinBorders(int TableID, int ThinBorders, double Red, double Green, double Blue) {
        if (LibraryLoaded) {
            return DPLSetTableThinBorders(InstanceID, TableID, ThinBorders, Red, Green, Blue);
        } else return 0;
    }

    public int SetTableThinBordersCMYK(int TableID, int ThinBorders, double C, double M, double Y, double K) {
        if (LibraryLoaded) {
            return DPLSetTableThinBordersCMYK(InstanceID, TableID, ThinBorders, C, M, Y, K);
        } else return 0;
    }

    public int SetTempFile(String FileName) {
        if (LibraryLoaded) {
            return DPLSetTempFileA(InstanceID, FileName);
        } else return 0;
    }

    public int SetTempPath(String NewPath) {
        if (LibraryLoaded) {
            return DPLSetTempPathA(InstanceID, NewPath);
        } else return 0;
    }

    public int SetTextAlign(int TextAlign) {
        if (LibraryLoaded) {
            return DPLSetTextAlign(InstanceID, TextAlign);
        } else return 0;
    }

    public int SetTextCharSpacing(double CharSpacing) {
        if (LibraryLoaded) {
            return DPLSetTextCharSpacing(InstanceID, CharSpacing);
        } else return 0;
    }

    public int SetTextColor(double Red, double Green, double Blue) {
        if (LibraryLoaded) {
            return DPLSetTextColor(InstanceID, Red, Green, Blue);
        } else return 0;
    }

    public int SetTextColorCMYK(double C, double M, double Y, double K) {
        if (LibraryLoaded) {
            return DPLSetTextColorCMYK(InstanceID, C, M, Y, K);
        } else return 0;
    }

    public int SetTextColorSep(String ColorName, double Tint) {
        if (LibraryLoaded) {
            return DPLSetTextColorSepA(InstanceID, ColorName, Tint);
        } else return 0;
    }

    public int SetTextExtractionArea(double Left, double Top, double Width, double Height) {
        if (LibraryLoaded) {
            return DPLSetTextExtractionArea(InstanceID, Left, Top, Width, Height);
        } else return 0;
    }

    public int SetTextExtractionOptions(int OptionID, int NewValue) {
        if (LibraryLoaded) {
            return DPLSetTextExtractionOptions(InstanceID, OptionID, NewValue);
        } else return 0;
    }

    public int SetTextExtractionScaling(int Options, double Horizontal, double Vertical) {
        if (LibraryLoaded) {
            return DPLSetTextExtractionScaling(InstanceID, Options, Horizontal, Vertical);
        } else return 0;
    }

    public int SetTextExtractionWordGap(double NewWordGap) {
        if (LibraryLoaded) {
            return DPLSetTextExtractionWordGap(InstanceID, NewWordGap);
        } else return 0;
    }

    public int SetTextHighlight(int Highlight) {
        if (LibraryLoaded) {
            return DPLSetTextHighlight(InstanceID, Highlight);
        } else return 0;
    }

    public int SetTextHighlightColor(double Red, double Green, double Blue) {
        if (LibraryLoaded) {
            return DPLSetTextHighlightColor(InstanceID, Red, Green, Blue);
        } else return 0;
    }

    public int SetTextHighlightColorCMYK(double C, double M, double Y, double K) {
        if (LibraryLoaded) {
            return DPLSetTextHighlightColorCMYK(InstanceID, C, M, Y, K);
        } else return 0;
    }

    public int SetTextHighlightColorSep(String ColorName, double Tint) {
        if (LibraryLoaded) {
            return DPLSetTextHighlightColorSepA(InstanceID, ColorName, Tint);
        } else return 0;
    }

    public int SetTextMode(int TextMode) {
        if (LibraryLoaded) {
            return DPLSetTextMode(InstanceID, TextMode);
        } else return 0;
    }

    public int SetTextRise(double Rise) {
        if (LibraryLoaded) {
            return DPLSetTextRise(InstanceID, Rise);
        } else return 0;
    }

    public int SetTextScaling(double ScalePercentage) {
        if (LibraryLoaded) {
            return DPLSetTextScaling(InstanceID, ScalePercentage);
        } else return 0;
    }

    public int SetTextShader(String ShaderName) {
        if (LibraryLoaded) {
            return DPLSetTextShaderA(InstanceID, ShaderName);
        } else return 0;
    }

    public int SetTextSize(double TextSize) {
        if (LibraryLoaded) {
            return DPLSetTextSize(InstanceID, TextSize);
        } else return 0;
    }

    public int SetTextSpacing(double Spacing) {
        if (LibraryLoaded) {
            return DPLSetTextSpacing(InstanceID, Spacing);
        } else return 0;
    }

    public int SetTextUnderline(int Underline) {
        if (LibraryLoaded) {
            return DPLSetTextUnderline(InstanceID, Underline);
        } else return 0;
    }

    public int SetTextUnderlineColor(double Red, double Green, double Blue) {
        if (LibraryLoaded) {
            return DPLSetTextUnderlineColor(InstanceID, Red, Green, Blue);
        } else return 0;
    }

    public int SetTextUnderlineColorCMYK(double C, double M, double Y, double K) {
        if (LibraryLoaded) {
            return DPLSetTextUnderlineColorCMYK(InstanceID, C, M, Y, K);
        } else return 0;
    }

    public int SetTextUnderlineColorSep(String ColorName, double Tint) {
        if (LibraryLoaded) {
            return DPLSetTextUnderlineColorSepA(InstanceID, ColorName, Tint);
        } else return 0;
    }

    public int SetTextUnderlineCustomDash(String DashPattern, double DashPhase) {
        if (LibraryLoaded) {
            return DPLSetTextUnderlineCustomDashA(InstanceID, DashPattern, DashPhase);
        } else return 0;
    }

    public int SetTextUnderlineDash(double DashOn, double DashOff) {
        if (LibraryLoaded) {
            return DPLSetTextUnderlineDash(InstanceID, DashOn, DashOff);
        } else return 0;
    }

    public int SetTextUnderlineDistance(double UnderlineDistance) {
        if (LibraryLoaded) {
            return DPLSetTextUnderlineDistance(InstanceID, UnderlineDistance);
        } else return 0;
    }

    public int SetTextUnderlineWidth(double UnderlineWidth) {
        if (LibraryLoaded) {
            return DPLSetTextUnderlineWidth(InstanceID, UnderlineWidth);
        } else return 0;
    }

    public int SetTextWordSpacing(double WordSpacing) {
        if (LibraryLoaded) {
            return DPLSetTextWordSpacing(InstanceID, WordSpacing);
        } else return 0;
    }

    public int SetTransparency(int Transparency) {
        if (LibraryLoaded) {
            return DPLSetTransparency(InstanceID, Transparency);
        } else return 0;
    }

    public int SetUpdateMode(int NewUpdateMode) {
        if (LibraryLoaded) {
            return DPLSetUpdateMode(InstanceID, NewUpdateMode);
        } else return 0;
    }

    public int SetViewerPreferences(int Option, int NewValue) {
        if (LibraryLoaded) {
            return DPLSetViewerPreferences(InstanceID, Option, NewValue);
        } else return 0;
    }

    public int SetXFAFormFieldAccess(String XFAFieldName, int NewAccess) {
        if (LibraryLoaded) {
            return DPLSetXFAFormFieldAccessA(InstanceID, XFAFieldName, NewAccess);
        } else return 0;
    }

    public int SetXFAFormFieldBorderColor(String XFAFieldName, double Red, double Green, double Blue) {
        if (LibraryLoaded) {
            return DPLSetXFAFormFieldBorderColorA(InstanceID, XFAFieldName, Red, Green, Blue);
        } else return 0;
    }

    public int SetXFAFormFieldBorderPresence(String XFAFieldName, int NewPresence) {
        if (LibraryLoaded) {
            return DPLSetXFAFormFieldBorderPresenceA(InstanceID, XFAFieldName, NewPresence);
        } else return 0;
    }

    public int SetXFAFormFieldBorderWidth(String XFAFieldName, double BorderWidth) {
        if (LibraryLoaded) {
            return DPLSetXFAFormFieldBorderWidthA(InstanceID, XFAFieldName, BorderWidth);
        } else return 0;
    }

    public int SetXFAFormFieldValue(String XFAFieldName, String NewValue) {
        if (LibraryLoaded) {
            return DPLSetXFAFormFieldValueA(InstanceID, XFAFieldName, NewValue);
        } else return 0;
    }

    public int SetXFAFromString(byte[] Source, int Options) {
        if (LibraryLoaded) {
            return DPLSetXFAFromString(InstanceID, Source, Options);
        } else return 0;
    }

    public int SignFile(String InputFileName, String OpenPassword, String SignatureFieldName, String OutputFileName, String PFXFileName, String PFXPassword, String Reason, String Location, String ContactInfo) {
        if (LibraryLoaded) {
            return DPLSignFileA(InstanceID, InputFileName, OpenPassword, SignatureFieldName, OutputFileName, PFXFileName, PFXPassword, Reason, Location, ContactInfo);
        } else return 0;
    }

    public int SplitPageText(int Options) {
        if (LibraryLoaded) {
            return DPLSplitPageText(InstanceID, Options);
        } else return 0;
    }

    public int StartPath(double StartX, double StartY) {
        if (LibraryLoaded) {
            return DPLStartPath(InstanceID, StartX, StartY);
        } else return 0;
    }

    public int StoreCustomDataFromFile(String Key, String FileName, int Location, int Options) {
        if (LibraryLoaded) {
            return DPLStoreCustomDataFromFileA(InstanceID, Key, FileName, Location, Options);
        } else return 0;
    }

    public int StoreCustomDataFromString(String Key, byte[] NewValue, int Location, int Options) {
        if (LibraryLoaded) {
            return DPLStoreCustomDataFromStringA(InstanceID, Key, NewValue, Location, Options);
        } else return 0;
    }

    public int TestTempPath() {
        if (LibraryLoaded) {
            return DPLTestTempPath(InstanceID);
        } else return 0;
    }

    public int TransformFile(String InputFileName, String Password, String OutputFileName, int TransformType, int Options) {
        if (LibraryLoaded) {
            return DPLTransformFileA(InstanceID, InputFileName, Password, OutputFileName, TransformType, Options);
        } else return 0;
    }

    public int UnlockKey(String LicenseKey) {
        if (LibraryLoaded) {
            return DPLUnlockKeyA(InstanceID, LicenseKey);
        } else return 0;
    }

    public int Unlocked() {
        if (LibraryLoaded) {
            return DPLUnlocked(InstanceID);
        } else return 0;
    }

    public int UpdateAndFlattenFormField(int Index) {
        if (LibraryLoaded) {
            return DPLUpdateAndFlattenFormField(InstanceID, Index);
        } else return 0;
    }

    public int UpdateAppearanceStream(int Index) {
        if (LibraryLoaded) {
            return DPLUpdateAppearanceStream(InstanceID, Index);
        } else return 0;
    }

    public int UpdateTrueTypeSubsettedFont(String SubsetChars) {
        if (LibraryLoaded) {
            return DPLUpdateTrueTypeSubsettedFontA(InstanceID, SubsetChars);
        } else return 0;
    }

    public int UseKerning(int Kern) {
        if (LibraryLoaded) {
            return DPLUseKerning(InstanceID, Kern);
        } else return 0;
    }

    public int UseUnsafeContentStreams(int SafetyLevel) {
        if (LibraryLoaded) {
            return DPLUseUnsafeContentStreams(InstanceID, SafetyLevel);
        } else return 0;
    }

}
