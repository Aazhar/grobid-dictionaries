package org.grobid.core.document;

import org.grobid.core.engines.SegmentationLabel;

import java.util.List;
import java.util.SortedSet;

/**
 * Created by med on 08.11.16.
 */
public class DictionaryDocument extends Document {
    private String lexicalEntries;

    public DictionaryDocument(Document document) {
        super(document.documentSource);
        lexicalEntries = null;

    }

    public SortedSet<DocumentPiece> getDocumentDictionaryPart(String segmentationLabel) {
        if (this.labeledBlocks == null) {
            LOGGER.debug("labeledBlocks is null");
            return null;
        } else {
            if (segmentationLabel == null) {
                System.out.println("DictionarySegmentationLabels.getLabel()  is null");
            }

            return this.labeledBlocks.get(segmentationLabel);
        }
    }
    public String getDictionaryDocumentPartText(String segmentationLabel) {
        SortedSet<DocumentPiece> pieces = getDocumentDictionaryPart(segmentationLabel);
        if (pieces == null) {
            return null;
        } else {
            return getDocumentPieceText(getDocumentDictionaryPart(segmentationLabel));
        }
    }
    public void setLexicalEntries(String LEs){
        this.lexicalEntries = LEs;
    }

    public String getLexicalEntries(){
        if (this.lexicalEntries == null) {
            LOGGER.debug("lexicalEntries block is null");
            return null;
        } else {

            return this.lexicalEntries;
        }
    }

}
