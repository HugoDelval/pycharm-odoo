package dev.ngocta.pycharm.odoo.model;

import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiReferenceContributor;
import com.intellij.psi.PsiReferenceRegistrar;
import com.jetbrains.python.psi.PyKeywordArgument;
import com.jetbrains.python.psi.PyStringLiteralExpression;
import dev.ngocta.pycharm.odoo.OdooNames;
import org.jetbrains.annotations.NotNull;

import static com.intellij.patterns.PlatformPatterns.psiElement;

public class OdooComputeFunctionReferenceContributor extends PsiReferenceContributor {
    public static final PsiElementPattern.Capture<PyStringLiteralExpression> COMPUTE_STRING_PATTERN =
            psiElement(PyStringLiteralExpression.class).withParent(
                    psiElement(PyKeywordArgument.class).withName(OdooNames.COMPUTE));


    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(COMPUTE_STRING_PATTERN, new OdooComputeFunctionReferenceProvider());
    }
}