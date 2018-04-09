package org.pdfsam.pdf;

import java.io.File;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicInteger;

import org.pdfsam.support.ObservableAtomicReference;
import org.sejda.model.pdf.PdfVersion;

public class PdfDocumentDescriptorData {
	public ObservableAtomicReference<PdfDescriptorLoadingStatus> loadingStatus;
	public AtomicInteger references;
	public ObservableAtomicReference<Integer> pages;
	public String password;
	public File file;
	public PdfVersion version;
	public Map<String, String> metadata;
	public SortedSet<Integer> validBookmarksLevels;

	public PdfDocumentDescriptorData(ObservableAtomicReference<PdfDescriptorLoadingStatus> loadingStatus,
			AtomicInteger references, ObservableAtomicReference<Integer> pages, Map<String, String> metadata,
			SortedSet<Integer> validBookmarksLevels) {
		this.loadingStatus = loadingStatus;
		this.references = references;
		this.pages = pages;
		this.metadata = metadata;
		this.validBookmarksLevels = validBookmarksLevels;
	}
}