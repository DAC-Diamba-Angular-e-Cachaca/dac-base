export class TextFormatter {
  public static cpfFormatter(cpf: string | undefined): string | undefined {
    return cpf?.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/g, '$1.$2.$3-$4') ?? undefined;
  }

  public static removeMask(text: string | undefined): string | undefined {
    return text?.replace(/[^0-9]/g, '') ?? undefined;
  };
}
