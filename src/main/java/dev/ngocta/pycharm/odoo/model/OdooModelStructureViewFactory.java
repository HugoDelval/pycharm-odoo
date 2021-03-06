package dev.ngocta.pycharm.odoo.model;

import com.intellij.ide.structureView.StructureViewBuilder;
import com.intellij.ide.structureView.StructureViewModel;
import com.intellij.ide.structureView.TreeBasedStructureViewBuilder;
import com.intellij.lang.PsiStructureViewFactory;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiFile;
import com.jetbrains.python.structureView.PyStructureViewModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class OdooModelStructureViewFactory implements PsiStructureViewFactory {
    @Nullable
    @Override
    public StructureViewBuilder getStructureViewBuilder(@NotNull PsiFile psiFile) {
        return new TreeBasedStructureViewBuilder() {
            @NotNull
            @Override
            public StructureViewModel createStructureViewModel(@Nullable Editor editor) {
                if (OdooModelUtils.isOdooModelFile(psiFile)) {
                    return new OdooModelStructureViewModel(psiFile, editor);
                }
                return new PyStructureViewModel(psiFile, editor);
            }

            @Override
            public boolean isRootNodeShown() {
                return false;
            }
        };
    }
}
