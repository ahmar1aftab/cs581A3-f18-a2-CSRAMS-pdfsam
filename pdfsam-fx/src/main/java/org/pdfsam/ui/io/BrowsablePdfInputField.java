/* 
 * This file is part of the PDF Split And Merge source code
 * Created on 16/mag/2014
 * Copyright 2013-2014 by Andrea Vacondio (andrea.vacondio@gmail.com).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as 
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.pdfsam.ui.io;

import static org.pdfsam.support.RequireUtils.requireNotNull;

import java.util.function.Consumer;

import org.pdfsam.context.DefaultI18nContext;
import org.pdfsam.support.TaskParametersBuildStep;
import org.pdfsam.support.io.FileType;
import org.pdfsam.ui.support.FXValidationSupport.ValidationState;
import org.sejda.conversion.PdfFileSourceAdapter;
import org.sejda.model.parameter.base.SinglePdfSourceTaskParameters;

/**
 * A {@link BrowsableFileField} letting the user select a PDF document as input for a {@link SinglePdfSourceTaskParameters}.
 * 
 * @author Andrea Vacondio
 *
 */
public class BrowsablePdfInputField extends BrowsableFileField implements
        TaskParametersBuildStep<SinglePdfSourceTaskParameters> {

    public BrowsablePdfInputField() {
        super(FileType.PDF);
    }

    public void apply(SinglePdfSourceTaskParameters params, Consumer<String> onError) {
        requireNotNull(params, "Cannot set PDF source on a null parameter instance");
        getTextField().validate();
        if (getTextField().getValidationState() == ValidationState.INVALID) {
            onError.accept(DefaultI18nContext.getInstance().i18n("The selected output file is invalid"));
        } else {
            params.setSource(new PdfFileSourceAdapter(getTextField().getText()).getPdfFileSource());
        }
    }
}
